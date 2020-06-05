package com.fox.entity;

import com.fox.model.ComponentModel;
import com.fox.model.TypeModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "component")
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double kPrice;
    private String name;
    private String description;
    @ManyToOne
    private Type type;

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Component id(Long id){
        this.id = id;
        return this;
    }

    public Component kPrice(double kPrice){
        this.kPrice = kPrice;
        return this;
    }

    public Component name(String name){
        this.name = name;
        return this;
    }

    public Component description(String description){
        this.description = description;
        return this;
    }

    public Component type(Type type){
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return Double.compare(component.kPrice, kPrice) == 0 &&
                Objects.equals(id, component.id) &&
                Objects.equals(name, component.name) &&
                Objects.equals(description, component.description) &&
                Objects.equals(type, component.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kPrice, name, description, type);
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", kPrice=" + kPrice +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }
}
