package com.fox.model.request;

public class TypeModelRequest {
    private String name;
    private String description;

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

    public TypeModelRequest name(String name){
        this.name = name;
        return this;
    }

    public TypeModelRequest description(String description){
        this.description = description;
        return this;
    }
}
