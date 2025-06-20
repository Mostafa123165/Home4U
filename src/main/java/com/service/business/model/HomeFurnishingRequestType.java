package com.service.business.model;

import com.service.base.model.BaseLkpEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "home_furnishing_request_type_lkp")
public class HomeFurnishingRequestType extends BaseLkpEntity<Integer> {
}
