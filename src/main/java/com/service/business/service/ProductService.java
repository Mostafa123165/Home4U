package com.service.business.service;

import com.service.base.model.SearchRequest;
import com.service.base.service.BaseServiceImpl;
import com.service.business.model.Business;
import com.service.business.model.Product;
import com.service.business.repository.ProductRepository;
import com.service.error.BadRequestException;
import com.service.userManagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService extends BaseServiceImpl<Product, Long> {

    private final UserService userService;
    private final BusinessService businessService;
    private final ProductRepository productReps;

    @Override
    public Product insert(Product product) {
        associateProductToBusiness(product);
        product.associateTheStockWithProduct(product.getStocks());
        return super.insert(product);
    }

    @Override
    public Product update(Product product) {
        associateProductToBusiness(product);
        product.associateTheStockWithProduct(product.getStocks());
        return super.update(product);
    }

    private void associateProductToBusiness(Product product) {
        Business business = businessService.findByUserId(userService.getCurrentUser().getId());
        if (business == null) {
            throw new BadRequestException("The current user is not associated with a business account.");
        }
        product.setBusiness(business);
    }

    public Page<Product> filter(Optional<SearchRequest> req) {
        SearchRequest searchRequest = req.orElse(new SearchRequest());
        Pageable pageable = PageRequest.of(searchRequest.getPageNumber(), searchRequest.getPageSize());

        validateSearchRequest(searchRequest);

        String name = null;
        Number businessId = null;
        List<Integer> businessTypeIds = null;
        List<Integer> colorIds = null;
        List<Integer> materialIds = null;
        Number minPrice = null;
        Number maxPrice = null;
        boolean inStock = false;

        if(searchRequest.getSearchCriteria() != null) {
            businessId = (Number) searchRequest.getSearchCriteria().getOrDefault("businessId",null);
            minPrice = (Number) searchRequest.getSearchCriteria().getOrDefault("minPrice",null);
            maxPrice = (Number) searchRequest.getSearchCriteria().getOrDefault("maxPrice",null);
            colorIds = (List<Integer>) searchRequest.getSearchCriteria().getOrDefault("colorIds",null);
            businessTypeIds = (List<Integer>) searchRequest.getSearchCriteria().getOrDefault("businessTypeIds",null);
            materialIds = (List<Integer>) searchRequest.getSearchCriteria().getOrDefault("materialIds",null);
            inStock = (boolean) searchRequest.getSearchCriteria().getOrDefault("inStock",false);
            name = (String) searchRequest.getSearchCriteria().getOrDefault("name",null);
        }

        return productReps.filter(
                businessId != null ? businessId.longValue() : 0,
                name,
                businessTypeIds,
                colorIds,
                materialIds,
                minPrice != null ? minPrice.doubleValue() : null,
                maxPrice != null ? maxPrice.doubleValue() : null,
                inStock,
                pageable);
    }

    private void validateSearchRequest(SearchRequest searchRequest) {
        Number businessId = (Number) searchRequest.getSearchCriteria().getOrDefault("businessId",null);
        if(businessId == null) {
            throw new BadRequestException("The business id is required.");
        }
    }

    public Page<Product> shopNow(Optional<SearchRequest> req) {
        SearchRequest searchRequest = req.orElse(new SearchRequest());
        Pageable pageable = PageRequest.of(searchRequest.getPageNumber(), searchRequest.getPageSize());

        String name = null;
        List<Integer> materialIds = null;
        List<Integer> colorIds = null;
        Number minPrice = null;
        Number businessTypeId = null;
        Number maxPrice = null;

        if (searchRequest.getSearchCriteria() != null) {
            name = (String) searchRequest.getSearchCriteria().getOrDefault("name", null);
            businessTypeId = (Number) searchRequest.getSearchCriteria().getOrDefault("businessTypeId", null);
            materialIds = (List<Integer>) searchRequest.getSearchCriteria().getOrDefault("materialIds", null);
            colorIds = (List<Integer>) searchRequest.getSearchCriteria().getOrDefault("colorIds", null);
            minPrice = (Number) searchRequest.getSearchCriteria().getOrDefault("minPrice", null);
            maxPrice = (Number) searchRequest.getSearchCriteria().getOrDefault("maxPrice", null);
        }

         Page<Product> products = productReps.shopNow(
                 name,
                 materialIds,
                 colorIds,
                 businessTypeId != null ? businessTypeId.intValue() : null,
                 minPrice != null ? minPrice.doubleValue() : null,
                 maxPrice != null ? maxPrice.doubleValue() : null,
                 pageable);

        productReps.findProductsWithImages(products.getContent().stream().map(Product::getId).toList());

        return products;
    }
}
