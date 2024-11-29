package com.service.base.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseLkpService<T,ID> {

    List<T> findAll();

    Page<T> findAll(Pageable pageable);

    T findById(ID id);

    T findByCode(String code);

    T insert(T entity);

    T update(T entity);

    List<T> saveAll(List<T> entities);
}
