package com.service.base.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class BaseLkpEntityDto<ID extends Serializable> {

    @Schema(description = "The database generated ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    private String code;
    private String name;
}
