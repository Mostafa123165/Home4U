package com.service.business.model;

import com.service.base.model.BaseEntity;
import com.service.common.model.Governorate;
import com.service.userManagement.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "home_furnishing_requests")
public class HomeFurnishingRequest extends BaseEntity<Long> {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_type_id")
    private HomeFurnishingRequestType requestType;

    @NotBlank
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "government_id")
    private Governorate government;

    @Min(1)
    @Column(name = "time_frame_days")
    private Integer timeFrameDays;

    @NotNull
    @Min(value = 0)
    private Double budget;

    @Column(name = "attachment_file_url")
    private String attachmentFileUrl;

    @Column(columnDefinition = "TEXT")
    private String note;

    @ManyToMany
    @JoinTable(name = "furnishing_request_product_materials",
            joinColumns = @JoinColumn(name = "furnishing_request_id"),
            inverseJoinColumns = @JoinColumn(name = "product_material_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"furnishing_request_id", "product_material_id"}))
    private Set<ProductMaterial> productMaterial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kitchen_type_id")
    private KitchenType kitchenType;

    @ManyToMany
    @JoinTable(name = "furnishing_request_devices_attacheds",
            joinColumns = @JoinColumn(name = "furnishing_request_id"),
            inverseJoinColumns = @JoinColumn(name = "devices_attached_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"furnishing_request_id", "devices_attached_id"}))
    private Set<DevicesAttached> devicesAttacheds;

    @Column(name = "kitchen_size")
    private Long kitchenSize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "furniture_type_id")
    private FurnitureType furnitureType;
}
