package com.projet.controler.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.projet.dao.IngrediantsDao;
import com.projet.model.bean.Ingrediant;
import com.projet.model.bean.Recipe;

@SuppressWarnings("serial")
@ManagedBean
@ApplicationScoped
@FacesConverter("myObjectConverter")

public class IngrediantsDaoControler implements Serializable{
	private IngrediantsDao ingrediantsDao;
	//private Recipe recipe;
	private String recipeName;
	private List<Ingrediant> ingrediants;
	
	
	
	public IngrediantsDaoControler() {
		this.ingrediantsDao = new IngrediantsDao();
		this.recipeName = "Test";
		this.ingrediants = new ArrayList<Ingrediant>();
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public List<Ingrediant> getIngrediants(){
		//For test
		//this.recipe.setName("Steak frites");//For test
		System.out.println(this.recipeName);
		this.ingrediants = this.ingrediantsDao.getListIngrediants(this.recipeName);
		return this.ingrediants;
	}



//	public Recipe getRecipe() {
//		return recipe;
//	}
//
//
//
//	public void setRecipe(Recipe recipe) {
//		this.recipe = recipe;
//	}
	
	
	

}
