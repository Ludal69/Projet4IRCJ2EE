package com.projet.controler.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.projet.dao.RecipesDao;
import com.projet.model.bean.Recipe;

@ManagedBean
@SessionScoped
public class RecipesDaoControler implements Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private RecipesDao recipesDao;
    private List<Recipe> recipes;
    
    private int durationWanted = 0;
    private int level = 0;
    private int numberPeople = 0;
    private String type = "";

    public RecipesDaoControler() {
        this.recipesDao = new RecipesDao();
        this.recipes = new ArrayList<Recipe>();
    }

    public List<Recipe> getRecipes() {
        this.recipes = this.recipesDao.getListRecipes();
        return recipes;
    }

    public String searchRecipe() {
        this.recipes =  this.recipesDao.searchRecipe(getDurationWanted(), getLevel(), getNumberPeople(), getType());
        return "splashScreen.jsf";
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

}
