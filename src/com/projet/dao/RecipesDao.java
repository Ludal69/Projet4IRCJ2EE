package com.projet.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import com.projet.model.bean.Ingrediant;
import com.projet.model.bean.Recipe;
import com.projet.model.bean.User;

public class RecipesDao extends AbstractDao {

    public RecipesDao() {
        super();
    }

    public List<Recipe> getListRecipes() {
        List<Recipe> recipes = new ArrayList<Recipe>();
        ResultSet resultSet = null;

        try {
            java.sql.Connection cnx = java.sql.DriverManager.getConnection(this.DB_CONFIG, this.DB_LOGIN, this.DB_PWD);
            // Cr�ation de la requ�te
            java.sql.Statement query = cnx.createStatement();

            // Cr�ation du contenu de la requ�te a �x�cuter
            String sql = "SELECT * FROM `recipe`";

            // Ex�cution de la requ�te de modification
            // query.executeUpdate(sql);

            resultSet = query.executeQuery(sql);

            while (resultSet.next()) {
                Recipe recipe = new Recipe();
                recipe.setName(resultSet.getString("name"));
                recipe.setDuration(resultSet.getInt("duration"));
                recipe.setLevel(resultSet.getInt("level"));
                recipe.setNumberPeople(resultSet.getInt("number_people"));
                recipe.setType(resultSet.getString("type"));
                recipes.add(recipe);
            }

            // cnx.commit();
            query.close();
            cnx.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recipes;
    }

    public List<Recipe> searchRecipe(int durationWanted, int level, int numberPeople, String type) {
        // TODO Auto-generated method stub
        List<Recipe> recipes = new ArrayList<Recipe>();
        ResultSet resultSet = null;

        try {
            java.sql.Connection cnx = java.sql.DriverManager.getConnection(this.DB_CONFIG, this.DB_LOGIN, this.DB_PWD);
            // Cr�ation de la requ�te
            java.sql.Statement query = cnx.createStatement();

            // Cr�ation du contenu de la requ�te a �x�cuter
             String sql = "SELECT * FROM `recipe` WHERE `duration` = " + durationWanted + " AND `level` = " + level + " AND `number_people` = " + numberPeople
             + " AND type LIKE '"+type+"';";

            // Ex�cution de la requ�te de modification
            // query.executeUpdate(sql);

            resultSet = query.executeQuery(sql);

            while (resultSet.next()) {
                Recipe recipe = new Recipe();
                recipe.setName(resultSet.getString("name"));
                recipe.setDuration(resultSet.getInt("duration"));
                recipe.setLevel(resultSet.getInt("level"));
                recipe.setNumberPeople(resultSet.getInt("number_people"));
                recipe.setType(resultSet.getString("type"));
                recipes.add(recipe);
            }

            // cnx.commit();
            query.close();
            cnx.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recipes;
    }
}
