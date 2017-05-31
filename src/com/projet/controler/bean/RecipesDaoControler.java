package com.projet.controler.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.projet.dao.RecipesDao;
import com.projet.model.bean.Recipe;


@ManagedBean
@SessionScoped

public class RecipesDaoControler implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public Recipe getRecipe(String name){
		Recipe recipe = null;
		System.out.println(name);
		for(Recipe i : this.recipes){
			System.out.println(i.getClass().getName());
			if (i.getName().equals(name)){
				recipe = (Recipe) i;
			}
		}
		return recipe;
	}
	
	
	
}
