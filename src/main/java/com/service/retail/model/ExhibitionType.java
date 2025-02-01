package com.service.retail.model;

import com.service.base.model.BaseLkpEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ret_exhibition_type_lkp")
public class ExhibitionType extends BaseLkpEntity<Integer> {
}
