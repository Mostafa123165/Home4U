package com.service.common.model;

import com.service.base.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "common_portal_config", uniqueConstraints=
@UniqueConstraint(columnNames ={"config_key"}))
@Schema(description = "Portal Config Model")
@Getter @Setter
public class PortalConfig extends BaseEntity<Long> {

	@Column(name = "config_key")
	private String configKey;

	@Column(name = "config_value")
	private String configValue;

}

