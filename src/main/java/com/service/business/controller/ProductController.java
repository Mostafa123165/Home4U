package com.service.business.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SearchRequest;
import com.service.base.model.SuccessResponsePage;
import com.service.business.dto.ProductDto;
import com.service.business.mapper.ProductMapper;
import com.service.business.model.Product;
import com.service.business.service.ProductService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Schema(name = "Product")
@RequestMapping("api/v1/products")
public class ProductController extends BaseControllerImpl<Product, ProductDto, Long> {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping("/filter")
    public ResponseEntity<?> filter(@RequestBody Optional<SearchRequest> searchRequest) {
        return ResponseEntity.ok(new SuccessResponsePage<>(productService.filter(searchRequest).map(productMapper::mapToProductCard)));
    }

    @PostMapping("/shop-now")
    public ResponseEntity<?> shopNow(@RequestBody Optional<SearchRequest> searchRequest) {
        return ResponseEntity.ok(new SuccessResponsePage<>(productService.shopNow(searchRequest).map(productMapper::mapToProductShopNow)));
    }
}
