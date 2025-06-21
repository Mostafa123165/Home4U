package com.service.freelancer.model;

import com.service.base.model.BaseEntity;
import com.service.userManagement.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "fre_engineer_rating")
public class EngineerRating extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "engineer_id", nullable = false)
    private Engineer engineer;
    private Integer rate;
    private String comment;
}
