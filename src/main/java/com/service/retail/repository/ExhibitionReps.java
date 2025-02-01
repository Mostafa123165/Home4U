package com.service.retail.repository;

import com.service.base.repository.BaseRepository;
import com.service.retail.model.Exhibition;
import org.springframework.stereotype.Repository;

@Repository
public interface ExhibitionReps extends BaseRepository<Exhibition,Long> {
}
