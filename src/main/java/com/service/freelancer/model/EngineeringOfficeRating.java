package com.service.freelancer.model;

import com.service.base.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "fre_engineering_office_rate")
public class EngineeringOfficeRating extends BaseEntity<Long> {
    @ManyToOne
    @JoinColumn(name = "office_id", nullable = false)
    private EngineeringOffice engineeringOffice;
    private Double rate;
    private String comment;
}