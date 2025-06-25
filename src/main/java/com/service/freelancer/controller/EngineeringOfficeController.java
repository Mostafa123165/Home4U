package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SearchRequest;
import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponsePage;
import com.service.freelancer.dto.EngineeringOfficeDto;
import com.service.freelancer.mapper.EngineeringOfficeMapper;
import com.service.freelancer.model.EngineeringOffice;
import com.service.freelancer.service.EngineeringOfficeService;
import com.service.userManagement.mapper.UserMapper;
import com.service.userManagement.model.User;
import com.service.userManagement.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/engineering-office")
@Tag(name = "Engineering Office")
public class EngineeringOfficeController extends BaseControllerImpl<EngineeringOffice, EngineeringOfficeDto, Long> {

    private final EngineeringOfficeService engineeringOfficeService;
    private final EngineeringOfficeMapper engineeringOfficeMapper;
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/user")
    public ResponseEntity<?> getByUserId(@RequestParam(required = false) Long userId) {
        EngineeringOfficeDto engineeringOfficeDto = engineeringOfficeMapper.map(engineeringOfficeService.findByUserId(userId));
        return ResponseEntity.ok(new SuccessResponse<>(engineeringOfficeDto));
    }

    @Override
    public ResponseEntity<?> update(@RequestBody EngineeringOfficeDto dto) {
        EngineeringOffice engineeringOffice = engineeringOfficeMapper.unMap(dto);
        User user = userService.findById(dto.getUser().getId());
        user = userMapper.UpdateMap(dto.getUser(), user);
        engineeringOffice.setUser(user);
        engineeringOffice = engineeringOfficeService.update(engineeringOffice);
        return ResponseEntity.ok(new SuccessResponse<>(engineeringOfficeMapper.map(engineeringOffice)));
    }

    @PostMapping("/filter-top")
    public ResponseEntity<?> filterTop(@Valid @RequestBody SearchRequest req) {
        Page<EngineeringOfficeDto> dtos = engineeringOfficeService.filterTop(Optional.ofNullable(req)).map(engineeringOfficeMapper::map);
        return ResponseEntity.ok(new SuccessResponsePage<EngineeringOfficeDto>(dtos));
    }
}
