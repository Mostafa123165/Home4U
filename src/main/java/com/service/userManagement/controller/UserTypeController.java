package com.service.userManagement.controller;

import com.service.base.controller.BaseLkpControllerImpl;
import com.service.base.model.SuccessResponseList;
import com.service.userManagement.dto.UserTypeDto;
import com.service.userManagement.mapper.UserTypeMapper;
import com.service.userManagement.model.UserType;
import com.service.userManagement.service.UserTypesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user-types")
@Tag(name = "UserType")
@AllArgsConstructor
public class UserTypeController extends BaseLkpControllerImpl<UserType, UserTypeDto,Integer> {

    private final UserTypesService userTypesService;
    private final UserTypeMapper userTypeMapper;

    @Override
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(new SuccessResponseList<>(userTypeMapper.map(userTypesService.findAll())));
    }
}
