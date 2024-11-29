package com.service.base.repository;

import com.service.base.model.BaseLkpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface BaseLkpRepository<T extends BaseLkpEntity<ID>,ID extends Serializable> extends JpaRepository<T,ID> {

    Optional<T> findByCode(String code);
}
