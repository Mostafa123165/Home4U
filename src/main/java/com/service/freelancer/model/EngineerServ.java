package com.service.freelancer.model;

import com.service.base.model.BaseLkpEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fre_engineer_service_lkp")
public class EngineerServ extends BaseLkpEntity<Integer> {

    @ManyToOne
    @JoinColumn(name = "engineer_id")
    private EngineerType engineerType;

}
