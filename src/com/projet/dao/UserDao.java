package com.projet.dao;

import java.sql.SQLException;

import com.projet.model.bean.User;

public class UserDao extends AbstractDao{
	
	public UserDao(){
		super();
	}
	
	public void addUser(User user) {
		try {
			java.sql.Connection cnx = java.sql.DriverManager.getConnection(
					DB_CONFIG, DB_LOGIN, DB_PWD);
			// Cr�ation de la requ�te
			java.sql.Statement query = cnx.createStatement();

			// Cr�ation du contenu de la requ�te a �x�cuter
			String sql = "INSERT INTO `"+this.DB_TABLE_NAME+"`.`user` (`firstname`,'lastname','login','pwd','email','age')"
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
