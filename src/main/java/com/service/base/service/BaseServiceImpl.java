package com.service.base.service;

import com.service.base.Constant;
import com.service.base.model.BaseEntity;
import com.service.base.repository.BaseRepository;
import com.service.error.RecordNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public abstract class BaseServiceImpl<T extends BaseEntity<ID>,ID extends Serializable> implements BaseService<T,ID> {

    @Autowired
    private BaseRepository<T,ID> baseRepository;

    @Autowired
    private MessageSource messageSource;

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return baseRepository.findAll(pageable);
    }

    @Override
    public T findById(ID id) {
        return baseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(
                messageSource.getMessage("exception.notfound.record",null, LocaleContextHolder.getLocale()))
        );
    }

    @Override
    public Optional<T> getById(ID id) {
        return baseRepository.findById(id);
    }

    @Override
    public T insert(T entity) {
        if(entity.getStatusCode() == null)
            entity.setStatusCode(Constant.StatusCodeEnum.DRAFT.getCode());
        return baseRepository.save(entity);
    }

    @Override
    public T update(T entity) {
        return baseRepository.save(entity);
    }

    @Override
    public List<T> saveAll(List<T> entities) {
        return baseRepository.saveAll(entities);
    }

    @Override
    public void deleteById(ID id) {
        baseRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<ID> ids) {
        baseRepository.deleteAllById(ids);
    }

}
