package com.projet.model.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/*
@ManagedBean
@SessionScoped
*/
public class Ingrediant{
	
	private String name = "";
	private String description = "";
	
	public Ingrediant() {
	}
	public Ingrediant(String name, String description) {
		super();
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
