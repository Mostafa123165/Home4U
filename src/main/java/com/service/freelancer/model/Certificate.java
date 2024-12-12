package com.service.freelancer.model;

import com.service.base.model.BaseEntity;
import com.service.userManagement.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "fre_certification")
public class Certificate extends BaseEntity<Long> {
    @NotNull
    private String name;

    private String description;

    private String path;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
