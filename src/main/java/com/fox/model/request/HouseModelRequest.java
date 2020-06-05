package com.fox.model.request;

import java.math.BigDecimal;
import java.util.List;

public class HouseModelRequest {
    private String name;
    private String description;
    private List<Long> componentIds;
    //price not include component price k
    private double basePrice;

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

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public HouseModelRequest name(String name){
        this.name = name;
        return this;
    }

    public HouseModelRequest description(String description){
        this.description = description;
        return this;
    }

    public HouseModelRequest componentIds(List<Long> componentIds){
        this.componentIds = componentIds;
        return this;
    }

    public HouseModelRequest basePrice(double basePrice){
        this.basePrice = basePrice;
        return this;
    }

    @Override
    public String toString() {
        return "HouseRequest{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", componentIds=" + componentIds +
                ", basePrice=" + basePrice +
                '}';
    }
}
