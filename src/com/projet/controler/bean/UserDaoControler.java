package com.projet.controler.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.projet.dao.UserDao;
import com.projet.model.bean.User;


@ManagedBean(name="userDaoControler")
@SessionScoped

public class UserDaoControler implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
    private UserDao userDao;

    public UserDaoControler() {
        this.userDao = new UserDao();
        this.user = new User();
    }
    
    public String removeUser(){
    	this.userDao.removeUser(this.user.getId());
    	return "adminUsers.xhtml";
    }
    
    public List<User> getAllUsers(){
    	return this.userDao.getAllUsers();
    }
    
    public String addUser() {
        this.userDao.addUser(this.user);
        return "splashScreen.jsf";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    

}
