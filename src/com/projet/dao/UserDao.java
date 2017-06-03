package com.projet.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.projet.model.bean.Ingrediant;
import com.projet.model.bean.Recipe;
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
	
	public void removeUser(long id){
		try {
			java.sql.Connection cnx = java.sql.DriverManager.getConnection(
					this.DB_CONFIG, this.DB_LOGIN, this.DB_PWD);
			// Cr�ation de la requ�te
			java.sql.Statement query = cnx.createStatement();

			// Cr�ation du contenu de la requ�te a �x�cuter
			String sql = "DELETE FROM `user` WHERE `user_id`="+id+"";
			

			// Ex�cution de la requ�te de modification
			query.executeUpdate(sql);

//			cnx.commit();
			query.close();
			cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<User> getAllUsers(){
		
		List<User> users = new ArrayList<User>();
        ResultSet resultSet = null;

        try {
            java.sql.Connection cnx = java.sql.DriverManager.getConnection(this.DB_CONFIG, this.DB_LOGIN, this.DB_PWD);
            // Cr�ation de la requ�te
            java.sql.Statement query = cnx.createStatement();

            // Cr�ation du contenu de la requ�te a �x�cuter
            String sql = "SELECT * FROM `user` ORDER BY `user_id` ASC";

            // Ex�cution de la requ�te de modification
            // query.executeUpdate(sql);

            resultSet = query.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("user_id"));
                user.setLogin(resultSet.getString("login"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstName(resultSet.getString("firstname"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getInt("age"));
                users.add(user);
            }

            // cnx.commit();
            query.close();
            cnx.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
	}

}
