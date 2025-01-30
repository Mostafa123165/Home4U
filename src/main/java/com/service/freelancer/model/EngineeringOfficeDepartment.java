package com.service.freelancer.model;

import com.service.base.model.BaseLkpEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fre_engineering_office_departments_lkp")
public class EngineeringOfficeDepartment extends BaseLkpEntity<Integer> {

    @ManyToOne
    @JoinColumn(name = "engineer_office_field_id")
    private EngineeringOfficeField EngineeringOfficeField;

}
