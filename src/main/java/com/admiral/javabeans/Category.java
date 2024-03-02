/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.admiral.javabeans;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <b>Javabean Category</b>
 * <p>Utilizamos Jakarta Validation</p>
 * <a href="https://www.baeldung.com/java-validation">Java Bean Validation Basics</a>
 * @author Carlos V.
 */
public class Category implements Serializable{
    private int id;
    @NotNull(message = "La categoria necesita un nombre")
    private String name;
    private boolean visible;
    private int category_super;
    
    public Category(){}
    
    public Category(int id, String name, boolean visible, int category_super){
        this.id = id;
        this.name = name;
        this.visible = visible;
        this.category_super = category_super;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getCategory_super() {
        return category_super;
    }

    public void setCategory_super(int category_super) {
        this.category_super = category_super;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", visible=" + visible + ", category_super=" + category_super + '}';
    }
    
}
