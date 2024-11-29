package com.service.userManagement.model;

import com.service.base.model.BaseLkpEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_type_lkp")
public class UserType extends BaseLkpEntity<Integer> {

}
