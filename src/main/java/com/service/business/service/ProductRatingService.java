package com.service.business.service;

import com.service.base.service.BaseServiceImpl;
import com.service.business.model.ProductRating;
import com.service.business.repository.ProductRatingRepository;
import com.service.common.service.MessageSourceService;
import com.service.error.BadRequestException;
import com.service.userManagement.model.User;
import com.service.userManagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductRatingService extends BaseServiceImpl<ProductRating, Long> {

    private final UserService userService;
    private final ProductRatingRepository productRatingRepository;
    private final MessageSourceService messageSourceService;

    @Override
    public ProductRating insert(ProductRating productRating) {
        associateCurrentUserWithProductRating(productRating);
        checkIfTheUserHasAlreadyRatedTheProduct(productRating);
        return super.insert(productRating);
    }

    @Override
    public ProductRating update(ProductRating productRating) {
        associateCurrentUserWithProductRating(productRating);
        return super.update(productRating);
    }

    private void checkIfTheUserHasAlreadyRatedTheProduct(ProductRating productRating) {
        boolean isProductRated = productRatingRepository.existsByProductIdAndUserId(
                productRating.getProduct().getId(), productRating.getUser().getId());
        if (isProductRated) {
            throw new BadRequestException(messageSourceService.getMessage("validation.product.already.rated"));
        }
    }

    private void associateCurrentUserWithProductRating(ProductRating productRating) {
        User user = userService.getCurrentUser();
        productRating.setUser(user);
    }

}

