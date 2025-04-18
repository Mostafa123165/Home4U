package com.service.freelancer.model;

import com.service.base.model.BaseEntity;
import com.service.userManagement.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fre_custom_package")
public class CustomPackage extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String nameAr;
    private String nameEn;


    private Double price;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String detailsAr;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String detailsEn;


}
