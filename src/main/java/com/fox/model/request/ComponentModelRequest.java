package com.fox.model.request;

public class ComponentModelRequest {
    private double kPrice;
    private String name;
    private String description;
    private Long typeId;

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

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public ComponentModelRequest kPrice(double kPrice){
        this.kPrice = kPrice;
        return this;
    }

    public ComponentModelRequest name(String name){
        this.name = name;
        return this;
    }

    public ComponentModelRequest description(String description){
        this.description = description;
        return this;
    }

    public ComponentModelRequest typeId(Long type){
        this.typeId = type;
        return this;
    }
}
