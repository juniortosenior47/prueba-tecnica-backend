package com.sysman.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "material")
public class MaterialDB {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="cityID")
    private Integer cityID;

    public Integer getCityID() {
        return cityID;
    }

    public void setCity(Integer cityID) {
        this.cityID = cityID;
    }

    @Column(name="name")
    private String name;
   
    @Column(name="description")
    private String description;

    @Column(name="type")
    private String type;

    @Column(name="purchaseat")
    private LocalDateTime purchaseAt;

    @Column(name="saleat")
    private LocalDateTime saleAt;

    @Column(name="status")
    private String status;

    

    public MaterialDB() {

    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getPurchaseAt() {
        return purchaseAt;
    }

    public void setPurchaseAt(LocalDateTime purchaseAt) {
        this.purchaseAt = purchaseAt;
    }

    public LocalDateTime getSaleAt() {
        return saleAt;
    }

    public void setSaleAt(LocalDateTime saleAt) {
        this.saleAt = saleAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
