package com.projet.controler.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.projet.dao.RecipesDao;
import com.projet.model.bean.Recipe;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped

public class RecipesDaoControler implements Serializable{
	private RecipesDao recipesDao;
	private List<Recipe> recipes;
	
	
	
	public RecipesDaoControler() {
		this.recipesDao = new RecipesDao();
		this.recipes = new ArrayList<Recipe>();
	}
	
	public List<Recipe> getRecipes(){
		this.recipes = this.recipesDao.getListRecipes();
		return this.recipes;
	}
	
	
	
}
