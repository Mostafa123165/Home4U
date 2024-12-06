package com.service.freelancer.model;

import com.service.base.model.BaseEntity;
import com.service.userManagement.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "fre_technical_worker")
public class TechnicalWorker extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "technical_worker_type_id")
    private TechnicalWorkerType type;

    @NotNull
    @Column(name = "years_of_experience", nullable = false)
    private Integer yearsOfExperience;

    @NotNull
    @ManyToMany
    @JoinTable(name = "fre_worker_service",
            uniqueConstraints = @UniqueConstraint(columnNames={"worker_id", "service_id"} ) ,
            joinColumns = @JoinColumn(name = "worker_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<TechnicalWorkerServ> workerServs;

}
