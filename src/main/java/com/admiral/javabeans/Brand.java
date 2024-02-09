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
public class Brand implements Serializable{
    private int id;
    @NotNull(message = "La marca necesita un nombre")
    private String name;
    private boolean visible;
    
    public Brand(){}
    
    public Brand(int id, String name, boolean visible){
        this.id = id;
        this.name = name;
        this.visible = visible;
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
}
