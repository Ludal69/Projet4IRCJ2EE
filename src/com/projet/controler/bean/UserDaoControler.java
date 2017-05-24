package com.projet.controler.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.project.dao.UserDao;
import com.projet.model.bean.User;

@ManagedBean
@SessionScoped

public class UserDaoControler {
	private User user;
	private UserDao userDao;
	
	public UserDaoControler(){
		this.userDao= new UserDao();
	}
	
	public void addUser(){
		this.userDao.addUser(this.user);
	}

}
