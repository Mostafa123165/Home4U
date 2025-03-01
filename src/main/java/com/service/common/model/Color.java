package com.service.common.model;

import com.service.base.model.BaseLkpEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "color_lkp")
public class Color extends BaseLkpEntity<Integer> {
    private String hexColor;
}
