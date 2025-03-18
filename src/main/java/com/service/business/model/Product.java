package com.service.business.model;

import com.service.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter @Setter
public class Product extends BaseEntity<Long> {

    @Column(name = "name_ar", nullable = false)
    private String nameAr;

    @Column(name = "name_en", nullable = false)
    private String nameEn;

    @Column(name = "description_ar",columnDefinition = "TEXT",nullable = false)
    private String descriptionAr;

    @Column(name = "description_en",columnDefinition = "TEXT",nullable = false)
    private String descriptionEn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id")
    private Business business;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_type_id", nullable = false)
    private BusinessType businessType;

    @ManyToMany
    @JoinTable(name = "products_materials",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "material_id"}))
    private Set<ProductMaterial> materials;

    @Column(name = "price",nullable = false)
    private double price;

    @Column(name = "length")
    private double length;

    @Column(name = "width")
    private double width;

    @Column(name = "height")
    private double height;

    @Transient
    private String mainImagePath;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProductImage> imagePaths;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProductStock> stocks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_unit_id")
    private ProductBaseUnit baseUnit;

    @Formula("(select COALESCE(ROUND(SUM(stock.amount),2),0) from product_stocks stock where stock.product_id = id)")
    private double stockAmount;

    @Transient
    private boolean inStock;

    public void associateTheStockWithProduct(List<ProductStock> stocks) {
        stocks.forEach(stock -> stock.setProduct(this));
    }

    public String getMainImagePath() {
        return getImagePaths().isEmpty() ? null : getImagePaths().get(0).getImagePath();
    }

    public boolean isInStock() {
        return stocks != null && !stocks.isEmpty();
    }
}
