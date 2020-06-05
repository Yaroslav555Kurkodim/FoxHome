package com.fox.entity;

import com.fox.model.HouseModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Component> components = new ArrayList<>();
    //price include component price k
    private Double price;

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

    public List<Component> getComponents() {
        return components;
    }

    public void setComponentIds(List<Component> components) {
        this.components = components;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public House id(Long id){
        this.id = id;
        return this;
    }

    public House name(String name){
        this.name = name;
        return this;
    }

    public House description(String description){
        this.description = description;
        return this;
    }

    public House components(List<Component> components){
        this.components = components;
        return this;
    }

    public House price(Double price){
        this.price = price;
        return this;
    }
}
