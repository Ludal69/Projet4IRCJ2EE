package com.projet.controler.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.projet.dao.IngrediantsDao;
import com.projet.model.bean.Ingrediant;
import com.projet.model.bean.Recipe;

public class IngrediantsDaoControler implements Serializable{
	private IngrediantsDao ingrediantsDao;
	private Recipe recipe;
	private List<Ingrediant> ingrediants;
	
	
	
	public IngrediantsDaoControler() {
		this.ingrediantsDao = new IngrediantsDao();
		this.recipe = new Recipe();
		this.ingrediants = new ArrayList<Ingrediant>();
	}



	public List<Ingrediant> getIngrediants(){
		//For test
		this.recipe.setName("riz cantonais");//For test
		this.ingrediants = this.ingrediantsDao.getListIngrediants(this.recipe);
		System.out.println(this.ingrediants);
		return this.ingrediants;
	}



	public Recipe getRecipe() {
		return recipe;
	}



	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	
	

}
