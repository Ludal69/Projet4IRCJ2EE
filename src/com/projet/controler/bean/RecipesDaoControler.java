package com.projet.controler.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.projet.dao.RecipesDao;
import com.projet.model.bean.Recipe;

@ManagedBean
@RequestScoped
public class RecipesDaoControler implements Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private RecipesDao recipesDao;
    private List<Recipe> recipes;
    private List<Integer> durations;
    private List<String> types;
    private Recipe recipeToAdd;
    
    
    private int durationWanted;
    private int level = 0;
    private int numberPeople = 0;
    private String type = "";

 
    public RecipesDaoControler() {
        super();
        this.recipesDao = new RecipesDao();
        this.recipes = new ArrayList<Recipe>();
        this.durations = new ArrayList<Integer>();
        this.types = new ArrayList<String>();
        this.recipeToAdd = new Recipe();
//        durations.add(22);
//        durations.add(55);
//        durations.add(15);
//        durations.add(135);
//        durations.add(35);
        
        types.add("Dessert");
        types.add("Meal");
        types.add("Fish");
    }



    public List<Recipe> getRecipes() {
        return this.recipes;
    }
    
    public List<Recipe> getAllRecipes() {
      this.recipes = this.recipesDao.getListRecipes();
      return this.recipes;
  }
    
    public List<Integer> getAllDurations() {
        this.durations = this.recipesDao.getallDurations();
        return this.durations;
    }
    

    public String searchRecipe() {
        this.recipes =  this.recipesDao.searchRecipe(getDurationWanted(), getLevel(), getNumberPeople(), getType());
        return "searchResults.xhtml";
    }

    // TEST
    public Recipe getRecipe(String name) {
        Recipe recipe = null;
        System.out.println(name);
        for (Recipe i : this.recipes) {
            System.out.println(i.getClass().getName());
            if (i.getName().equals(name)) {
                recipe = (Recipe) i;
            }
        }
        return recipe;
    }

    
    public String deleteRecepie(String recepieName){
    	this.recipesDao.deleteRecipe(recepieName);
    	return "adminRecipes.xhtml";
    }
    
    public String addRecipe(){
    	this.recipesDao.addRecipe(this.recipeToAdd);
    	return "adminRecipes.xhtml";
    }
    
    
    public RecipesDao getRecipesDao() {
        return recipesDao;
    }



    public void setRecipesDao(RecipesDao recipesDao) {
        this.recipesDao = recipesDao;
    }



    public List<Integer> getDurations() {
        return durations;
    }



    public void setDurations(List<Integer> durations) {
        this.durations = durations;
    }



    public static long getSerialversionuid() {
        return serialVersionUID;
    }



    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }



    public int getDurationWanted() {
        return durationWanted;
    }

    public void setDurationWanted(int durationWanted) {
        this.durationWanted = durationWanted;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getNumberPeople() {
        return numberPeople;
    }

    public void setNumberPeople(int numberPeople) {
        this.numberPeople = numberPeople;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public List<String> getTypes() {
        return types;
    }



    public void setTypes(List<String> types) {
        this.types = types;
    }



	public Recipe getRecipeToAdd() {
		return recipeToAdd;
	}



	public void setRecipeToAdd(Recipe recipeToAdd) {
		this.recipeToAdd = recipeToAdd;
	}
    
    
    

}
