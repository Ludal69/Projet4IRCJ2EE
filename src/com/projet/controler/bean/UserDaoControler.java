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
    private int userIdToDelete;

    public UserDaoControler() {
        this.userDao = new UserDao();
        this.user = new User();
        this.userIdToDelete = 0;
    }
    
    public String removeUser(){
    	this.userDao.removeUser(this.userIdToDelete);
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

	public int getUserIdToDelete() {
		return userIdToDelete;
	}

	public void setUserIdToDelete(int userIdToDelete) {
		this.userIdToDelete = userIdToDelete;
	}
    
    

}
