package com.service.freelancer.controller;

import com.service.base.controller.BaseLkpControllerImpl;
import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponseList;
import com.service.freelancer.dto.EngineeringOfficeDepartmentDto;
import com.service.freelancer.mapper.EngineeringOfficeDepartmentMapper;
import com.service.freelancer.model.EngineeringOfficeDepartment;
import com.service.freelancer.service.EngineeringOfficeDepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/engineering-office-department")
@Tag(name = "Engineering Office Department")
public class EngineeringOfficeDepartmentController extends BaseLkpControllerImpl<EngineeringOfficeDepartment, EngineeringOfficeDepartmentDto,Integer> {

    private final EngineeringOfficeDepartmentService engineeringOfficeDepartmentService;
    private final EngineeringOfficeDepartmentMapper engineeringOfficeDepartmentMapper;

    @GetMapping("/field/{id}")
    @Operation(summary = "Get engineer service")
    public ResponseEntity<?> service (@PathVariable Long id) {
        List<EngineeringOfficeDepartmentDto> engineerServs =engineeringOfficeDepartmentMapper.map(engineeringOfficeDepartmentService.getEngineeringOfficeDepartmentByFieldId(id));
        return ResponseEntity.ok(new SuccessResponseList<>(engineerServs));
    }

    @GetMapping("/department")
    @Operation(summary = "Get his own Technical Worker services")
    public ResponseEntity<?> getEngineeringOfficeDepartment (@RequestParam Long engineeringOfficeId) {
        List<EngineeringOfficeDepartmentDto> engineeringOfficeDepartmentDtos =
                engineeringOfficeDepartmentMapper.map(
                        engineeringOfficeDepartmentService.getEngineeringOfficeDepartment(engineeringOfficeId)
                );
        return ResponseEntity.ok(new SuccessResponseList<>(engineeringOfficeDepartmentDtos));
    }

    @PutMapping("/department/update")
    @Operation(summary = "Get his own Technical Worker services")
    public ResponseEntity<?> updateOwnEngineeringOfficeDepartments (@RequestParam Long userId,@RequestBody List<EngineeringOfficeDepartmentDto> engineeringOfficeDepartmentDtos) {
        engineeringOfficeDepartmentService.updateOwnEngineeringOfficeDepartments(userId,engineeringOfficeDepartmentMapper.unMap(engineeringOfficeDepartmentDtos));
        return ResponseEntity.ok(new SuccessResponse<>(true));
    }

    @DeleteMapping("/department")
    public ResponseEntity<?> deleteEngineeringOfficeDepartment(@RequestParam Long engineeringOfficeId, @RequestParam Long engineeringOfficeDepartmentId) {
        engineeringOfficeDepartmentService.deleteByEngineeringOfficeIdAndEngineeringOfficeDepartmentId(engineeringOfficeId, engineeringOfficeDepartmentId);
        return ResponseEntity.ok(new SuccessResponse<>(true));
    }
}
