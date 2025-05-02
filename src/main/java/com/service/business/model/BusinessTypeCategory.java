package com.service.business.model;

import com.service.base.model.BaseLkpEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "business_type_category_lkp")
@Getter @Setter
public class BusinessTypeCategory extends BaseLkpEntity<Integer>{


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_type_id")
    private BusinessType businessType;
}
