package com.projet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projet.model.bean.Ingrediant;
import com.projet.model.bean.Recipe;

public class IngrediantsDao extends AbstractDao{
	
	public IngrediantsDao(){
		super();
	}
	
	public List<Ingrediant> getListIngrediants(Recipe recipe){
		
		List<Ingrediant> ingrediants = new ArrayList<Ingrediant>();
		ResultSet resultSet = null;
		
		try {
			java.sql.Connection cnx = java.sql.DriverManager.getConnection(
					this.DB_CONFIG, this.DB_LOGIN, this.DB_PWD);
			// Cr�ation de la requ�te
			java.sql.Statement query = cnx.createStatement();

			// Cr�ation du contenu de la requ�te a �x�cuter
			String sql ="SELECT i.ingrediant_id, i.name, i.description FROM `recipelinkingrediant` AS l "+
					"JOIN ingrediant AS i ON l.ingrediant_id=i.ingrediant_id "+
					"JOIN recipe AS r ON l.recipe_id=r.recipe_id "+
					"WHERE r.name LIKE '"+recipe.getName()+"';";

			// Ex�cution de la requ�te de modification
			//query.executeUpdate(sql);
			
			resultSet = query.executeQuery(sql);
			
			while (resultSet.next()) {
				Ingrediant ingrediant = new Ingrediant();
				ingrediant.setName(resultSet.getString("name"));
				ingrediant.setDescription(resultSet.getString("description"));
				ingrediants.add(ingrediant);
			}

//			cnx.commit();
			query.close();
			cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ingrediants;
	}

}
