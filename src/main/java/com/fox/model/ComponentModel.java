package com.fox.model;

import java.math.BigDecimal;

public class ComponentModel {
    private Long id;
    private double kPrice;
    private String name;
    private String description;
    private TypeModel type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getkPrice() {
        return kPrice;
    }

    public void setkPrice(double kPrice) {
        this.kPrice = kPrice;
    }

    public String getName() {
        return name;
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

    public TypeModel getType() {
        return type;
    }

    public void setType(TypeModel type) {
        this.type = type;
    }

    public ComponentModel id(Long id){
        this.id = id;
        return this;
    }

    public ComponentModel kPrice(double kPrice){
        this.kPrice = kPrice;
        return this;
    }

    public ComponentModel name(String name){
        this.name = name;
        return this;
    }

    public ComponentModel description(String description){
        this.description = description;
        return this;
    }

    public ComponentModel type(TypeModel type){
        this.type = type;
        return this;
    }
}
