package com.service.freelancer.model;

import com.service.base.model.BaseEntity;
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
@Table(name = "fre_technical_worker_rating")
public class TechnicalWorkerRating extends BaseEntity<Long> {
    @ManyToOne
    @JoinColumn(name = "worker_id", nullable = false)
    private TechnicalWorker technicalWorker;
    private Integer rate;
    private String comment;
}