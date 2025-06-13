package com.service.business.controller;


import com.service.base.controller.BaseControllerImpl;
import com.service.business.dto.ProductRatingDto;
import com.service.business.model.ProductRating;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Schema(name = "Product Rate" )
@RequestMapping("api/v1/product-ratings")
public class ProductRatingController extends BaseControllerImpl<ProductRating, ProductRatingDto, Long> {


}
