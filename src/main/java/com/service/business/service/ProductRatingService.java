package com.service.business.service;

import com.service.base.model.SearchRequest;
import com.service.base.service.BaseServiceImpl;
import com.service.business.dto.ProductRatingResponseDTO;
import com.service.business.model.Product;
import com.service.business.model.ProductRating;
import com.service.business.repository.ProductRatingRepository;
import com.service.common.service.MessageSourceService;
import com.service.error.BadRequestException;
import com.service.userManagement.model.User;
import com.service.userManagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProductRatingService extends BaseServiceImpl<ProductRating, Long> {

    private final UserService userService;
    private final ProductRatingRepository productRatingRepository;
    private final MessageSourceService messageSourceService;
    private final ProductService productService;

    @Override
    @Transactional
    public ProductRating insert(ProductRating productRating) {
        associateCurrentUserWithProductRating(productRating);
        checkIfTheUserHasAlreadyRatedTheProduct(productRating);
        productService.updateProductRate(productRating.getProduct().getId(),productRating.getRate(),1);
        return super.insert(productRating);
    }

    @Override
    @Transactional
    public ProductRating update(ProductRating productRating) {
        associateCurrentUserWithProductRating(productRating);
        Double oldProductRate = getProductRateById(productRating.getId());
        if(!oldProductRate.equals(productRating.getRate())) {
            productService.updateProductRate(productRating.getProduct().getId(), oldProductRate, -1);
            productService.updateProductRate(productRating.getProduct().getId(), oldProductRate, +1);
        }
        return super.update(productRating);
    }

    @Override
    @Transactional
    public void deleteById(Long productRatingId) {
        ProductRating productRating = findById(productRatingId);
        productService.updateProductRate(productRatingId,productRating.getRate(),-1);
        super.deleteById(productRatingId);
    }

    private void checkIfTheUserHasAlreadyRatedTheProduct(ProductRating productRating) {
        boolean isProductRated =existsByProductIdAndUserId(
                productRating.getProduct().getId(), productRating.getUser().getId());
        if (isProductRated) {
            throw new BadRequestException(messageSourceService.getMessage("validation.product.already.rated"));
        }
    }

    private void associateCurrentUserWithProductRating(ProductRating productRating) {
        User user = userService.getCurrentUser();
        productRating.setUser(user);
    }


    public boolean existsByProductIdAndUserId(Long productId, Long userId) {
        return productRatingRepository.existsByProductIdAndUserId(productId, userId);
    }

    public Page<ProductRatingResponseDTO> getProductRatingsWithFilters(SearchRequest searchRequest) {


        Pageable pageable = PageRequest.of(searchRequest.getPageNumber(), searchRequest.getPageSize());
        Number productId = (Number) searchRequest.getSearchCriteria().getOrDefault("productId",null);
        Number stars = (Number) searchRequest.getSearchCriteria().getOrDefault("stars",null);
        Boolean isTopRated = (Boolean) searchRequest.getSearchCriteria().getOrDefault("isTopRated",null);

        return productRatingRepository.findAllByFilters(
                productId.longValue(),
                stars == null ? null : stars.doubleValue(),
                isTopRated,
                pageable
        );
    }


    private Double getProductRateById(Long productRateId) {
        return productRatingRepository.getProductRateById(productRateId);
    }


}
