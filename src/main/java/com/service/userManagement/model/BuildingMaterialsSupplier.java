package com.service.userManagement.model;

import com.service.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "building_materials_supplier")
public class BuildingMaterialsSupplier extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
