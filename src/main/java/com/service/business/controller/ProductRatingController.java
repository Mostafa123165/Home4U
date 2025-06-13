package com.service.business.controller;


import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SearchRequest;
import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponsePage;
import com.service.business.dto.ProductRatingDto;
import com.service.business.mapper.ProductRatingMapper;
import com.service.business.model.ProductRating;
import com.service.business.service.ProductRatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Schema(name = "Product Rate" )
@RequestMapping("api/v1/product-ratings")
public class ProductRatingController extends BaseControllerImpl<ProductRating, ProductRatingDto, Long> {

    private final ProductRatingService productRatingService;
    private final ProductRatingMapper productRatingMapper;



    @GetMapping("/check")
    @Operation(summary = "Check if user has already rated a product")
    public ResponseEntity<?> checkIfTheUserHasAlreadyRatedTheProduct(
            @RequestParam Long productId,
            @RequestParam Long userId) {
        return ResponseEntity.ok(new SuccessResponse<>(productRatingService.existsByProductIdAndUserId(productId, userId)));
    }

    @PostMapping("/filter")
    @Operation(summary = "Get product ratings with filters")
    public ResponseEntity<?> getProductRatings(@RequestBody SearchRequest searchRequest) {
        return ResponseEntity.ok(new SuccessResponsePage<>(productRatingService.getProductRatingsWithFilters(searchRequest)));
    }
}

