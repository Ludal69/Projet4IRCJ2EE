package com.projet.dao;

public abstract class AbstractDao {
	
	protected static final String DB_CONFIG = "jdbc:mysql://localhost:3306/bdd_tp";
	protected String DB_TABLE_NAME = "projet4irc_jee";
	protected static final String DB_LOGIN = "root";
	protected static final String DB_PWD = "";
	
	protected AbstractDao(){
		// Chargement du Driver, puis �tablissement de la connexion
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

}
