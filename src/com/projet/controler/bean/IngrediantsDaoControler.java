package com.projet.controler.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.projet.dao.IngrediantsDao;
import com.projet.model.bean.Ingrediant;
import com.projet.model.bean.Recipe;

@SuppressWarnings("serial")
@ManagedBean
@ApplicationScoped

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
		//this.recipe.setName("riz cantonais");//For test
		System.out.println(this.recipe.getName());
		this.ingrediants = this.ingrediantsDao.getListIngrediants(this.recipe);
		for(int i=0;i<4;i++){
			System.out.println(this.ingrediants.get(i).getName());
		}
		return this.ingrediants;
	}



	public Recipe getRecipe() {
		return recipe;
	}



	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	
	

}
