package com.service.business.model;

import com.service.base.model.BaseLkpEntity;
import com.service.userManagement.model.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "business_type_lkp")
@Getter @Setter
public class BusinessType extends BaseLkpEntity<Integer>{


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_type_id")
    private UserType userType;
}
