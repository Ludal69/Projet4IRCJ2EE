package com.projet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.projet.model.bean.Ingrediant;
import com.projet.model.bean.User;

public class UserDao extends AbstractDao{
	
	public UserDao(){
		super();
	}
	
	public boolean userExist(User user){
		boolean ret = false;
		ResultSet resultSet = null;
		
		try {
			java.sql.Connection cnx = java.sql.DriverManager.getConnection(
					this.DB_CONFIG, this.DB_LOGIN, this.DB_PWD);
			// Cr�ation de la requ�te
			java.sql.Statement query = cnx.createStatement();

			// Cr�ation du contenu de la requ�te a �x�cuter
			String sql ="SELECT * FROM `user` "+
						"WHERE `login` LIKE '"+user.getLogin()+"' "+
						"AND `pwd` LIKE '"+user.getPwd()+"';";

			// Ex�cution de la requ�te de modification
			//query.executeUpdate(sql);
			
			resultSet = query.executeQuery(sql);
			if(resultSet.next() == true){
				ret = true;
			}else{
				ret = false;
			}

//			cnx.commit();
			query.close();
			cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public void addUser(User user) {
		try {
			java.sql.Connection cnx = java.sql.DriverManager.getConnection(
					this.DB_CONFIG, this.DB_LOGIN, this.DB_PWD);
			// Cr�ation de la requ�te
			java.sql.Statement query = cnx.createStatement();

			// Cr�ation du contenu de la requ�te a �x�cuter
			String sql = "INSERT INTO `"+this.DB_TABLE_NAME+"`.`user` (`firstname`,`lastname`,`login`,`pwd`,`email`,`age`)"
					+ " VALUES ('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getLogin()+"','"+user.getPwd()+"','"+user.getEmail()+"','"+user.getAge()+"');";
			

			// Ex�cution de la requ�te de modification
			query.executeUpdate(sql);

//			cnx.commit();
			query.close();
			cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
