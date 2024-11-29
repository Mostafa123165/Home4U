package com.service.base.mapper;

import java.util.List;
import java.util.Set;

public interface BaseMapper<T,DTO> {

    DTO map(T t);

    T unMap(DTO dto);

    List<DTO> map(List<T> t);

    Set<DTO> map (Set<T> t);

    List<T> unMap(List<DTO> dto);

    Set<T> unMap(Set<DTO> dto);

}
