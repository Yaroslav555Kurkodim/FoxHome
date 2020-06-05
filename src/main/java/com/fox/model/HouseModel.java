package com.fox.model;

import java.math.BigDecimal;
import java.util.List;

public class HouseModel {
    private Long id;
    private String name;
    private String description;
    private List<Long> componentIds;
    //price include component price k
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Long> getComponentIds() {
        return componentIds;
    }

    public void setComponentIds(List<Long> componentIds) {
        this.componentIds = componentIds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public HouseModel id(Long id){
        this.id = id;
        return this;
    }

    public HouseModel name(String name){
        this.name = name;
        return this;
    }

    public HouseModel description(String description){
        this.description = description;
        return this;
    }

    public HouseModel componentIds(List<Long> componentIds){
        this.componentIds = componentIds;
        return this;
    }

    public HouseModel price(double price){
        this.price = price;
        return this;
    }
}
