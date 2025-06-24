package com.service.business.controller;

import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponseList;
import com.service.business.model.ProductVisit;
import com.service.business.service.ProductVisitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Schema(name = "Product Visits")
@RequestMapping("api/v1/product-visits")
public class ProductVisitController {

    private final ProductVisitService productVisitService;

    @Operation(summary = "Record a product visit")
    @PostMapping("/{productId}")
    public ResponseEntity<?> recordVisit(@PathVariable Long productId) {
        productVisitService.recordVisit(productId);
        return ResponseEntity.ok(new SuccessResponse<>("Visit recorded successfully"));
    }


}
