package com.service.base.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BaseService<T,ID> {

    List<T> findAll();

    Page<T> findAll(Pageable pageable);

    T findById(ID id);

    Optional<T> getById(ID id);

    T insert(T entity);

    T update(T entity);

    List<T> saveAll(List<T> entities);

    void deleteById(ID id);

    void deleteAll(List<ID> ids);
}
