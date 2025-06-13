package com.service.business.controller;


import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponse;
import com.service.business.dto.ProductRatingDto;
import com.service.business.model.ProductRating;
import com.service.business.service.ProductRatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Schema(name = "Product Rate" )
@RequestMapping("api/v1/product-ratings")
public class ProductRatingController extends BaseControllerImpl<ProductRating, ProductRatingDto, Long> {

    private final ProductRatingService productRatingService;

    @GetMapping("/check")
    @Operation(summary = "Check if user has already rated a product")
    public ResponseEntity<?> checkIfTheUserHasAlreadyRatedTheProduct(
            @RequestParam Long productId,
            @RequestParam Long userId) {
        return ResponseEntity.ok(new SuccessResponse<>(productRatingService.existsByProductIdAndUserId(productId, userId)));
    }
}
