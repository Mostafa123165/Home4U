package com.service.common.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageSourceService {

    private final MessageSource messageSource;

    public String getMessage(String key) {
        return messageSource.getMessage(key,null, LocaleContextHolder.getLocale());
    }

    public String getMessage(String key,String[] params) {
        return messageSource.getMessage(key,params, LocaleContextHolder.getLocale());
    }

}
