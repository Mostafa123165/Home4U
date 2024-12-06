package com.service.base.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface BaseLkpController<T,DTO,ID> {

    @GetMapping
    ResponseEntity<?> findAll();

    @GetMapping("/page")
    ResponseEntity<?> findAll(@RequestParam Optional<Integer> page,
                              @RequestParam Optional<Integer> size,
                              @RequestParam Optional<String> sortableColumn);

    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable ID id);

    @PostMapping
    ResponseEntity<?> insert(@RequestBody DTO dto);

    @PutMapping
    ResponseEntity<?> update(@RequestBody DTO dto);

    @PostMapping("/all")
    ResponseEntity<?> saveAll(@RequestBody List<DTO> list);

}
