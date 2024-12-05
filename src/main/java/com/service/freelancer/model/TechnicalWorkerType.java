package com.service.freelancer.model;

import com.service.base.model.BaseLkpEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "technical_worker_type_lkp")
public class TechnicalWorkerType extends BaseLkpEntity<Integer> {

}
