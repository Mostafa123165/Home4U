package com.service.common.model;

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
@Table(name = "city_lkp")
public class City extends BaseLkpEntity<Integer> {

    @ManyToOne
    @JoinColumn(name = "governorate_id")
    private Governorate governorate;
}
