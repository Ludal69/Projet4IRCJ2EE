package com.projet.model.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Recipe implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private String name = "";
    private int duration = 0;
    private int level = 0;
    private int numberPeople = 0;
    private String type = "";

    public Recipe() {

    }

    /** GETTERS & SETTERS */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getNumberPeople() {
        return numberPeople;
    }

    public void setNumberPeople(int numberPeople) {
        this.numberPeople = numberPeople;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
