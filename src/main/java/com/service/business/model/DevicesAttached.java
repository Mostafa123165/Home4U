package com.service.business.model;

import com.service.base.model.BaseLkpEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "devices_attached_lkp")
public class DevicesAttached extends BaseLkpEntity<Integer> {
}

