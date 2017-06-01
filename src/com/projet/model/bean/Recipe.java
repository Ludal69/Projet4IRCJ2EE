package com.projet.model.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class Recipe implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String name = "";
	private String description = "";
	public Recipe() {
	
	}
	
	public Recipe(String name, String description) {
		this.name = name;
		this.description = description;
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

	
	
	

}
