package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SearchRequest;
import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponsePage;
import com.service.freelancer.dto.TechnicalWorkerDto;
import com.service.freelancer.mapper.TechnicalWorkerMapper;
import com.service.freelancer.model.TechnicalWorker;
import com.service.freelancer.service.TechnicalWorkerService;
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
@RequestMapping("api/v1/technical-workers")
@Tag(name = "TechnicalWorker")
public class TechnicalWorkerController extends BaseControllerImpl<TechnicalWorker, TechnicalWorkerDto, Long> {

    private final TechnicalWorkerService technicalWorkerService;
    private final TechnicalWorkerMapper technicalWorkerMapper;
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/user")
    public ResponseEntity<?> getByUserId(@RequestParam(required = false) Long userId) {
        return ResponseEntity.ok(new SuccessResponse<>(technicalWorkerMapper.map(technicalWorkerService.findByUserId(userId))));
    }

    @Override
    public ResponseEntity<?> update(@RequestBody TechnicalWorkerDto dto) {
        TechnicalWorker technicalWorker = technicalWorkerMapper.unMap(dto);
        User user = userService.findById(dto.getUser().getId());
        user = userMapper.UpdateMap(dto.getUser(), user);
        technicalWorker.setUser(user);
        technicalWorker = technicalWorkerService.update(technicalWorker);
        return ResponseEntity.ok(new SuccessResponse<>(technicalWorkerMapper.map(technicalWorker)));
    }

    @PostMapping("/filter-top")
    public ResponseEntity<?> filterTop(@Valid @RequestBody SearchRequest req) {
        Page<TechnicalWorkerDto> dtos = technicalWorkerService.filterTop(Optional.ofNullable(req)).map(technicalWorkerMapper::map);
        return ResponseEntity.ok(new SuccessResponsePage<TechnicalWorkerDto>(dtos));
    }
}
