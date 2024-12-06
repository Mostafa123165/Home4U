package com.service.freelancer.model;

import com.service.base.model.BaseLkpEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "fre_technical_worker_service_lkp")
public class TechnicalWorkerServ extends BaseLkpEntity<Integer> {

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private TechnicalWorkerType technicalWorkerType;

}
