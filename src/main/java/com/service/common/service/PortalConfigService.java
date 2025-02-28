package com.service.common.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.base.service.BaseServiceImpl;
import com.service.common.model.PortalConfig;
import com.service.common.repository.PortalConfigReps;
import com.service.error.RecordNotFoundException;

@Service
public class PortalConfigService extends BaseServiceImpl<PortalConfig, Long> {

    @Autowired
    private PortalConfigReps portalConfigReps;

    public Optional<PortalConfig> findByConfigKey(String key) {

        return portalConfigReps.findByConfigKey(key);
    }

    public String findConfigValue(String key) {

        Optional<PortalConfig> config = portalConfigReps.findByConfigKey(key);
        if (config.isPresent()) {
            return config.get().getConfigValue();
        } else {
            throw new RecordNotFoundException("This Configration not found :- " + key);
        }
    }

    public int deleteAllConfig() {

        return portalConfigReps.deleteAllConfig();
    }

}
