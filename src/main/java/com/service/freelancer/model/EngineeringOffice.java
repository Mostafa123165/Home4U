package com.service.freelancer.model;

import com.service.base.model.BaseEntity;
import com.service.userManagement.model.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "fre_engineering_office")
public class EngineeringOffice extends BaseEntity<Long> {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private String tradeName;

    private String description;

    private String commercialRegisterPath;

    private String taxCardPath;

    private String personalCardPath;

    @ManyToOne
    @JoinColumn(name = "fields_id")
    private EngineeringOfficeField engineeringOfficeField;

    @ManyToMany
    @JoinTable(name = "fre_engineering_office_department",
            uniqueConstraints = @UniqueConstraint(columnNames={"engineering_office_id", "department_id"} ) ,
            joinColumns = @JoinColumn(name = "engineering_office_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private List<EngineeringOfficeDepartment> engineerServ;

}
