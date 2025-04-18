package com.service.freelancer.model;

import com.service.base.model.BaseEntity;
import com.service.userManagement.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fre_select_custom_package")
public class SelectCustomPackage  extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String phoneNumber;

    private Boolean isInsideCompound;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "Unit_type_id")
    private UnitType unitType;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "custom_package_id")
    private CustomPackage customPackage;

}
