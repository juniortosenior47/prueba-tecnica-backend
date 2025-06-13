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
    private Integer id;

    @Column(name="countiesID")
    private Integer countiesID;

    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;
   

    public CityDB() {

    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountiesID() {
        return countiesID;
    }

    public void setCountiesID(Integer countiesID) {
        this.countiesID = countiesID;
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
