package com.projet.model.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped

public class Recipe implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private List<Ingrediant> ingrediants;
	public Recipe() {
	
	}
	
	public Recipe(String name, String description, List<Ingrediant> ingrediants) {
		this.name = name;
		this.description = description;
		this.ingrediants = ingrediants;
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

	public List<Ingrediant> getIngrediants() {
		return ingrediants;
	}

	public void setIngrediants(List<Ingrediant> ingrediants) {
		this.ingrediants = ingrediants;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
