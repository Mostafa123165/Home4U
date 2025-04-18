package com.service.freelancer.model;


import com.service.base.model.BaseEntity;
import com.service.business.model.ProductMaterial;
import com.service.common.model.City;
import com.service.common.model.Governorate;
import com.service.userManagement.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "fre_ask_worker")
public class AskWorker extends BaseEntity<Long> {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String projectName;

    private String phoneNumber;

    @Column(name = "project_description", length = 1000)
    private String projectDescription;

    @ManyToOne
    @JoinColumn(name = "worker_type_id", nullable = false)
    private TechnicalWorkerType workerType;

    @ManyToOne
    @JoinColumn(name = "unit_type_id", nullable = false)
    private UnitType unitType;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "governorate_id", nullable = false)
    private Governorate governorate;

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    private ProductMaterial material;

    private Long budget;

    @OneToMany(mappedBy = "askWorker", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AskWorkerPhotos> photos ;


}
