package com.service.freelancer.model;

import com.service.base.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fre_project_image")
@NoArgsConstructor
public class ProjectImage extends BaseEntity<Long> {

    @NonNull
    private String path;

    @ManyToOne
    private Project project;


    public ProjectImage(@NonNull String path, Project project) {
        this.path = path;
        this.project = project;
    }
}
