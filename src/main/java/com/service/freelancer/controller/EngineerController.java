package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SearchRequest;
import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponseList;
import com.service.base.model.SuccessResponsePage;
import com.service.freelancer.dto.EngineerDto;
import com.service.freelancer.dto.TechnicalWorkerDto;
import com.service.freelancer.mapper.EngineerMapper;
import com.service.freelancer.model.Engineer;
import com.service.freelancer.service.EngineerService;
import com.service.userManagement.mapper.UserMapper;
import com.service.userManagement.model.User;
import com.service.userManagement.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/engineers")
@Tag(name = "Engineer")
public class EngineerController extends BaseControllerImpl<Engineer, EngineerDto, Long> {

    private final EngineerService engineerService;
    private final EngineerMapper engineerMapper;
    private final UserService userService;
    private final UserMapper userMapper;


    @GetMapping("/user")
    public ResponseEntity<?> getByUserId(@RequestParam(required = false) Long userId) {
        return ResponseEntity.ok(new SuccessResponse<>(engineerMapper.map(engineerService.findByUserId(userId))));
    }

    @Override
    public ResponseEntity<?> update(@RequestBody EngineerDto dto) {
        Engineer engineeringOffice = engineerMapper.unMap(dto);
        User user = userService.findById(dto.getUser().getId());
        user = userMapper.UpdateMap(dto.getUser(), user);
        engineeringOffice.setUser(user);
        engineeringOffice = engineerService.update(engineeringOffice);
        return ResponseEntity.ok(new SuccessResponse<>(engineerMapper.map(engineeringOffice)));
    }

    @PostMapping("/filter-top")
    public ResponseEntity<?> filterTop(@Valid @RequestBody SearchRequest req) {
        Page<EngineerDto> dtos = engineerService.filterTop(Optional.ofNullable(req)).map(engineerMapper::map);
        return ResponseEntity.ok(new SuccessResponsePage<EngineerDto>(dtos));
    }

    @GetMapping("/top-engineers")
    public ResponseEntity<?> LandingPage() {
        List<EngineerDto> dtos = engineerMapper.map(engineerService.LandingPage());
        return ResponseEntity.ok(new SuccessResponseList<EngineerDto>(dtos));
    }
}
