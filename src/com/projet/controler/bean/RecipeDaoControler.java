package com.projet.controler.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.projet.dao.RecipeDao;
import com.projet.model.bean.Ingrediant;
import com.projet.model.bean.Recipe;

public class RecipeDaoControler implements Serializable{
	private RecipeDao recipeDao;
	private Recipe recipe;
	private List<Ingrediant> ingrediants;
	
	
	
	public RecipeDaoControler() {
		this.recipeDao = new RecipeDao();
		this.recipe = new Recipe();
		this.ingrediants = new ArrayList<Ingrediant>();
	}



	public List<Ingrediant> getListIngrediants(Recipe recipe){
		//For test
		recipe.setName("riz cantonais");//For test
		this.ingrediants = this.recipeDao.getListIngrediants(recipe);
		return this.ingrediants;
	}
	
	public void setRec
	

}
