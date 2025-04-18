package com.service.freelancer.model;

import com.service.base.model.BaseEntity;
import com.service.common.model.Governorate;
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
@Table(name = "fre_request_design")
public class RequestDesign extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String phoneNumber;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "Unit_type_id")
    private UnitType unitType;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "governorate_id")
    private Governorate governorate;

    private Long unitArea;

    private Long budget;

    private Long requiredDuration;

    private String notes;

}
