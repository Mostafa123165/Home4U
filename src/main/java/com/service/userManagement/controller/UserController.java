package com.service.userManagement.controller;

import com.service.base.model.SuccessResponse;
import com.service.userManagement.dto.UserDto;
import com.service.userManagement.mapper.UserMapper;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/info")
    public UserDto getUserInfo() {
        return userMapper.map(userService.getCurrentUser());
    }

    @PostMapping(path = "/personal_photo", consumes = "multipart/form-data")
    public ResponseEntity<?> uploadProject(
            @RequestPart("image") MultipartFile image) {
        userService.addPersonalPhoto(image);
        return ResponseEntity.ok(new SuccessResponse<>(true));
    }

}
