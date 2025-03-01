package com.service.business.model;

import com.service.base.model.BaseLkpEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "product_material_lkp")
public class ProductMaterial extends BaseLkpEntity<Integer> {
}
