package com.service.base.controller;

import com.service.base.dto.BaseEntityDto;
import com.service.base.mapper.BaseMapper;
import com.service.base.model.BaseEntity;
import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponseList;
import com.service.base.model.SuccessResponsePage;
import com.service.base.service.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
public abstract class BaseControllerImpl<T extends BaseEntity<ID>,DTO extends BaseEntityDto<ID>,ID extends Serializable> implements BaseController<T,DTO,ID>{

    @Autowired
    private  BaseServiceImpl<T,ID> baseService;
    @Autowired
    private  BaseMapper<T,DTO> baseMapper;

    @Override
    public ResponseEntity<?> findAll() {
        List<DTO> entities = baseMapper.map(baseService.findAll());
        return ResponseEntity.ok(new SuccessResponseList<>(entities));
    }

    @Override
    public ResponseEntity<?> findAll(@RequestParam Optional<Integer> page,
                                     @RequestParam Optional<Integer> size,
                                     @RequestParam Optional<String> sortableColumn) {
        Sort sort = Sort.by(sortableColumn.orElse("id"));
        Pageable pageable = PageRequest.of(page.orElse(0), size.orElse(10), sort);
        return ResponseEntity.ok(new SuccessResponsePage<>(baseService.findAll(pageable)));
    }

    @Override
    public ResponseEntity<?> findById(@PathVariable ID id) {
        DTO entity = baseMapper.map(baseService.findById(id));
        return ResponseEntity.ok(new SuccessResponse<>(entity));
    }

    @Override
    public ResponseEntity<?> insert(@RequestBody DTO dto) {
        T entity = baseMapper.unMap(dto);
        return ResponseEntity.ok(new SuccessResponse<>(baseService.insert(entity)));
    }

    @Override
    public ResponseEntity<?> update(@RequestBody DTO dto) {
        T entity = baseMapper.unMap(dto);
        return ResponseEntity.ok(new SuccessResponse<>(baseService.update(entity)));
    }

    @Override
    public ResponseEntity<?> deleteById(@PathVariable ID id) {
        baseService.deleteById(id);
        return ResponseEntity.ok(new SuccessResponse<>(true));
    }

    @Override
    public ResponseEntity<?> saveAll(@RequestBody List<DTO> list) {
        List<T> entity = baseMapper.unMap(list);
        return ResponseEntity.ok(new SuccessResponseList<>(baseService.saveAll(entity)));
    }

    @Override
    public ResponseEntity<?> deleteAll(@RequestParam List<ID> list) {
        baseService.deleteAll(list);
        return ResponseEntity.ok(new SuccessResponse<>(true));
    }
}
