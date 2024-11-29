package com.service.userManagement.controller;

import com.service.base.controller.BaseLkpControllerImpl;
import com.service.userManagement.dto.UserTypeDto;
import com.service.userManagement.model.UserType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user-types")
public class UserTypeController extends BaseLkpControllerImpl<UserType, UserTypeDto,Integer> {


}
