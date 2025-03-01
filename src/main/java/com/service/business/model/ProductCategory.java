package com.service.business.model;

import com.service.base.model.BaseLkpEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_category_lkp")
@Getter @Setter
public class ProductCategory extends BaseLkpEntity<Long> {

}
