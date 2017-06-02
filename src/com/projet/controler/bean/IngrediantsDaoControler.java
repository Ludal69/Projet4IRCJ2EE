package com.projet.controler.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.projet.dao.IngrediantsDao;
import com.projet.model.bean.Ingrediant;
import com.projet.model.bean.Recipe;


@ManagedBean

@RequestScoped
//@FacesConverter("myObjectConverter")

public class IngrediantsDaoControler implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IngrediantsDao ingrediantsDao;
	//private Recipe recipe;
	
	private String recipeName;
	private List<Ingrediant> ingrediants;
	private Recipe recipe;
	
	
	public IngrediantsDaoControler() {
		this.ingrediantsDao = new IngrediantsDao();
		this.recipeName = "riz";
		this.recipe = new Recipe();
		this.ingrediants = new ArrayList<Ingrediant>();
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
		System.out.println(this.recipeName);
	}

	public List<Ingrediant> getIngrediants(String recipeName){
		//For test
		//this.recipe.setName("Steak frites");//For test
		System.out.println(recipeName);
		this.ingrediants = this.ingrediantsDao.getListIngrediants(recipeName);
		return this.ingrediants;
	}



	public Recipe getRecipe() {
		return this.recipe;
	}



	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	
	

}
