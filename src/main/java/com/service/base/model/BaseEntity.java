package com.service.base.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    @Schema(description = "The row status 1-draft , 2-confirmed , 3-approved , 4-rejected , 5-active , 6-inactive")
    private Integer statusCode = 5;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
