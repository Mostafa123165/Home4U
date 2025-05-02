package com.service.base.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface BaseController<T,DTO,ID>{

    @GetMapping
    ResponseEntity<?> findAll();

    @GetMapping("/page")
    ResponseEntity<?> findAll(@RequestParam Optional<Integer> page,
                              @RequestParam Optional<Integer> size,
                              @RequestParam Optional<String> sortableColumn);

    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable ID id);

    @PostMapping
    ResponseEntity<?> insert(@Valid @RequestBody DTO dto);

    @PutMapping
    ResponseEntity<?> update(@Valid @RequestBody DTO dto);

    @PostMapping("/all")
    ResponseEntity<?> saveAll(@Valid @RequestBody List<DTO> dtos);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteById(@PathVariable ID id);

    @DeleteMapping("/all")
    ResponseEntity<?> deleteAll(@RequestParam List<ID> ids);
}
