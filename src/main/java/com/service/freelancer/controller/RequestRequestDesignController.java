package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponseList;
import com.service.freelancer.dto.RequestRequestDesignDto;
import com.service.freelancer.mapper.RequestRequestDesignMapper;
import com.service.freelancer.model.RequestRequestDesign;
import com.service.freelancer.service.RequestRequestDesignService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/request-request-design")
@Tag(name = "  Request Request Design")
public class RequestRequestDesignController extends BaseControllerImpl<RequestRequestDesign, RequestRequestDesignDto, Long> {

    private final RequestRequestDesignService requestRequestDesignService;
    private final RequestRequestDesignMapper requestRequestDesignMapper;

    @GetMapping("/my-asks")
    public ResponseEntity<?> getMyAsks(@RequestParam Long askId) {
        List<RequestRequestDesignDto> dtos = requestRequestDesignMapper.map(requestRequestDesignService.getByAskId(askId));
        return ResponseEntity.ok(new SuccessResponseList<RequestRequestDesignDto>(dtos));
    }

    @Override
    public ResponseEntity<?> update(@RequestBody RequestRequestDesignDto dto) {
        RequestRequestDesign entity1 = requestRequestDesignService.findById(dto.getId());
        RequestRequestDesign entity2 = requestRequestDesignMapper.UpdateMap(dto, entity1);
        RequestRequestDesign result = requestRequestDesignService.update(entity2);
        RequestRequestDesignDto dtos = requestRequestDesignMapper.map(result);
        return ResponseEntity.ok(new SuccessResponse<>(dtos));
    }
}