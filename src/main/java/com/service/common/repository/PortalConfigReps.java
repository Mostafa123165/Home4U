package com.service.common.repository;

import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.service.base.repository.BaseRepository;
import com.service.common.model.PortalConfig;

@Repository
public interface PortalConfigReps extends BaseRepository<PortalConfig, Long> {
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	Optional<PortalConfig> findByConfigKey (String key);
	
	@Transactional
	@Query("delete from PortalConfig")
	int deleteAllConfig();

}
