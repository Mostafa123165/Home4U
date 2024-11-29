package com.service.base.service;

import com.service.base.Constant;
import com.service.base.model.BaseEntity;
import com.service.base.model.BaseLkpEntity;
import com.service.base.repository.BaseLkpRepository;
import com.service.base.repository.BaseRepository;
import com.service.error.RecordNotFoundException;
import jakarta.persistence.MappedSuperclass;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@MappedSuperclass
public abstract class BaseLkpServiceImpl<T extends BaseLkpEntity<ID>,ID extends Serializable> implements BaseLkpService<T,ID> {

    @Autowired
    private  BaseLkpRepository<T,ID> baseLkpRepository;

    @Autowired
    private  MessageSource messageSource;

    @Override
    public List<T> findAll() {
        return baseLkpRepository.findAll();
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return baseLkpRepository.findAll(pageable);
    }

    @Override
    public T findById(ID id) {
        return baseLkpRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(
                messageSource.getMessage("exception.notfound.record",null, LocaleContextHolder.getLocale()))
        );
    }

    @Override
    public T findByCode(String code) {
        return baseLkpRepository.findByCode(code).orElseThrow(() -> new RecordNotFoundException(
                messageSource.getMessage("exception.notfound.record",null, LocaleContextHolder.getLocale()))
        );
    }

    @Override
    public T insert(T entity) {
        if(entity.getStatusCode() == null)
            entity.setStatusCode(Constant.StatusCodeEnum.DRAFT.getCode());
        return baseLkpRepository.save(entity);
    }

    @Override
    public T update(T entity) {
        return baseLkpRepository.save(entity);
    }

    @Override
    public List<T> saveAll(List<T> entities) {
        return baseLkpRepository.saveAll(entities);
    }
}
