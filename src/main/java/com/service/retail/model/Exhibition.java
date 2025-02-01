package com.service.retail.model;

import com.service.base.model.BaseEntity;
import com.service.userManagement.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ret_exhibitions")
public class Exhibition extends BaseEntity<Long> {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "ret_exhibitions_types",
            joinColumns = @JoinColumn(name = "exhibition_id"),
            inverseJoinColumns = @JoinColumn(name = "exhibition_type_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"exhibition_id","exhibition_type_id"}))
    private Set<ExhibitionType> types;

    @Column(name = "trad_name", nullable = false)
    private String tradName;

    @Column(name = "bio_ar", nullable = false,columnDefinition = "TEXT")
    private String bioAr;

    @Column(name = "bio_en", nullable = false,columnDefinition = "TEXT")
    private String bioEn;

    @Column(name = "image_path")
    private String imagePath;

}
