package com.service.business.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.business.dto.HomeFurnishingRequestDto;
import com.service.business.model.HomeFurnishingRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Schema(name = "Home Furnishing Request")
@RequestMapping("api/v1/home-furnishing-requests")
public class HomeFurnishingRequestController extends BaseControllerImpl<HomeFurnishingRequest, HomeFurnishingRequestDto, Long> {



    @Override
    public ResponseEntity<?> insert(HomeFurnishingRequestDto dto) {
        return super.insert(dto);
    }
}
