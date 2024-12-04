package com.service.base.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseLkpEntity<ID extends Serializable> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    @NotBlank
    @Column(unique = true)
    private String code;

    @NotBlank
    @Column(name = "name_ar")
    private String nameAr;

    @NotBlank
    @Column(name = "name_en")
    private String nameEn;

    @Schema(description = "The row status 1-draft , 2-confirmed , 3-approved , 4-rejected , 5-active , 6-inactive")
    @Column(name = "status_code")
    private Integer statusCode;
}
