package com.fox.model;

public class TypeModel {
    private Long id;
    private String name;
    private String description;

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

    public TypeModel id(Long id){
        this.id = id;
        return this;
    }

    public TypeModel name(String name){
        this.name = name;
        return this;
    }

    public TypeModel description(String description){
        this.description = description;
        return this;
    }
}
