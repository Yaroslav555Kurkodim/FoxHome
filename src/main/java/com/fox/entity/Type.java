package com.fox.entity;

import com.fox.model.TypeModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Component> components = new ArrayList<>();

    public void addComponent(Component component){
        components.add(component);
        component.setType(this);
    }

    public void removeComponent(Component component){
        components.remove(component);
        component.setType(null);
    }

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

    public Type id(Long id){
        this.id = id;
        return this;
    }

    public Type name(String name){
        this.name = name;
        return this;
    }

    public Type description(String description){
        this.description = description;
        return this;
    }

    public Type comments(List<Component> components){
        this.components = components;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return Objects.equals(id, type.id) &&
                Objects.equals(name, type.name) &&
                Objects.equals(description, type.description) &&
                Objects.equals(components, type.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, components);
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", components=" + components +
                '}';
    }
}
