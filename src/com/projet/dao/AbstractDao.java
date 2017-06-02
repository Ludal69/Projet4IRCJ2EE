package com.projet.dao;

public abstract class AbstractDao {
	
	protected String DB_CONFIG = "jdbc:mysql://localhost/projetjee";
	protected String DB_TABLE_NAME = "projetjee";
	protected String DB_LOGIN = "root";
	protected String DB_PWD = "";
	
	protected AbstractDao(){
		// Chargement du Driver, puis �tablissement de la connexion
		this.DB_CONFIG = "jdbc:mysql://localhost/projetjee";
		this.DB_TABLE_NAME = "projetjee";
		this.DB_LOGIN = "root";
		this.DB_PWD = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

}
