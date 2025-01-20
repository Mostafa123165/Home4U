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
@Table(name = "fre_engineer")
public class Engineer extends BaseEntity<Long> {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "engineer_type_id")
    private EngineerType type;

    @NotNull
    @Column(name = "years_of_experience", nullable = false)
    private int yearsOfExperience;

    @ManyToMany
    @JoinTable(name = "fre_engineer_service",
            uniqueConstraints = @UniqueConstraint(columnNames={"engineer_id", "service_id"} ) ,
            joinColumns = @JoinColumn(name = "engineer_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<EngineerServ> engineerServ;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "linkedin_link")
    private String linkedin;

    @Column(name = "behance_link")
    private String behance;

}
