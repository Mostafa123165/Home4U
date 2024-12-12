package com.service.freelancer.model;

import com.service.base.model.BaseEntity;
import com.service.userManagement.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "fre_project")
public class Project extends BaseEntity<Long> {
    @NotNull
    private String name;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private String tools;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private List<ProjectImage> images;

    private String coverPath;



}