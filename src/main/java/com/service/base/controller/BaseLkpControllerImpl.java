package com.service.base.controller;

import com.service.base.dto.BaseLkpEntityDto;
import com.service.base.mapper.BaseMapper;
import com.service.base.model.BaseLkpEntity;
import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponseList;
import com.service.base.model.SuccessResponsePage;
import com.service.base.service.BaseLkpServiceImpl;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
public abstract class BaseLkpControllerImpl<T extends BaseLkpEntity<ID>,DTO extends BaseLkpEntityDto<ID>,ID extends Serializable> implements BaseLkpController<T,DTO,ID>{

    @Autowired
    private BaseLkpServiceImpl<T,ID> baseLkpService;

    @Autowired
    private BaseMapper<T,DTO> baseMapper;

    @Override
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(new SuccessResponseList<>(baseMapper.map(baseLkpService.findAll())));
    }

    @Override
    public ResponseEntity<?> findAll(Optional<Integer> page, Optional<Integer> size, Optional<String> sortableColumn) {
        Sort sort = Sort.by(sortableColumn.orElse("id"));
        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(10), sort);
        return ResponseEntity.ok(new SuccessResponsePage<>(baseLkpService.findAll(pageable)));
    }

    @Override
    public ResponseEntity<?> findById(@RequestParam ID id) {
        return ResponseEntity.ok(new SuccessResponse<>(baseLkpService.findById(id)));
    }

    @Override
    public ResponseEntity<?> insert(@RequestBody DTO dto) {
        T entity = baseMapper.unMap(dto);
        return ResponseEntity.ok(new SuccessResponse<>(baseLkpService.insert(entity)));
    }

    @Override
    public ResponseEntity<?> update(@RequestBody DTO dto) {
        T entity = baseMapper.unMap(dto);
        return ResponseEntity.ok(new SuccessResponse<>(baseLkpService.update(entity)));
    }

    @Override
    public ResponseEntity<?> saveAll(@RequestBody List<DTO> list) {
        List<T> entity = baseMapper.unMap(list);
        return ResponseEntity.ok(new SuccessResponseList<>(baseLkpService.saveAll(entity)));
    }
}
