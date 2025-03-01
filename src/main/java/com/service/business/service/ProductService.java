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

        Number businessId = null;
        if(searchRequest.getSearchCriteria() != null) {
            businessId = (Number) searchRequest.getSearchCriteria().getOrDefault("businessId",null);
        }


        return productReps.filter(
                businessId.longValue(),
                pageable);
    }
}
