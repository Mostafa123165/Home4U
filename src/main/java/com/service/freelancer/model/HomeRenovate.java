package com.service.freelancer.model;


import com.service.base.model.BaseEntity;
import com.service.common.model.City;
import com.service.common.model.Governorate;
import com.service.userManagement.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fre_home_renovate")
public class HomeRenovate extends BaseEntity<Long> {

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
    @JoinColumn(name = "unit_statuses_id")
    private UnitStatuses unitStatuses;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "unit_work_types_id")
    private UnitWorkTypes unitWorkTypes;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "work_skills_id")
    private WorkSkills workSkills;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "governorate_id")
    private Governorate governorate;

    private Long unitArea;

    private Long budget;

    private Long region;

    private Long numberOfRooms;

    private Long numberOfBathrooms;

    private Long requiredDuration;

    private String notes;

}
