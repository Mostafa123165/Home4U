package com.service.business.model;

import com.service.base.model.BaseEntity;
import com.service.userManagement.model.User;
import com.service.userManagement.model.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "businesses")
@Getter @Setter
public class Business extends BaseEntity<Long> {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private UserType userType;

    @Column(name = "trad_name", nullable = false)
    private String tradName;

    @Column(name = "bio_ar", nullable = false, columnDefinition = "TEXT")
    private String bioAr;

    @Column(name = "bio_en", nullable = false, columnDefinition = "TEXT")
    private String bioEn;

    @Column(name = "image_path")
    private String imagePath;

    @ManyToMany
    @JoinTable(
            name = "businesses_types",
            joinColumns = @JoinColumn(name = "business_id"),
            inverseJoinColumns = @JoinColumn(name = "business_type_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"business_id", "business_type_id"}))
    private Set<BusinessType> businessTypes;
}
