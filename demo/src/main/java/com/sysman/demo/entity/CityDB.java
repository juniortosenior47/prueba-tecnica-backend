package com.sysman.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "city")
public class CityDB {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="countiesID")
    private Integer counties;


    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;
   

    public CityDB() {

    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
