package com.projet.controler.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.projet.dao.RecipesDao;
import com.projet.model.bean.Recipe;

@ManagedBean
@ViewScoped
public class RecipesDaoControler implements Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private RecipesDao recipesDao;
    private List<Recipe> recipes;
    private String test = "BOB";
    private List<String> list;

    public RecipesDaoControler() {
        this.recipesDao = new RecipesDao();
        this.recipes = new ArrayList<Recipe>();
        this.list = new ArrayList<String>();
    }
    
    public List<String> init() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        
        return list;
    }
    
//    public RecipesDaoControler() {
//        this.recipesDao = new RecipesDao();
//        this.recipes = new ArrayList<Recipe>();
//        this.list = new ArrayList<String>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//        list.add("e");
//        list.add("f");
//    }



    public List<Recipe> getRecipes() {
        this.recipes = this.recipesDao.getListRecipes();
        System.out.println(recipes.get(2).getName());
        return recipes;
    }

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

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

}
