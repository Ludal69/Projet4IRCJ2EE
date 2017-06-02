package com.projet.controler.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.projet.dao.UserDao;
import com.projet.model.bean.User;

@ManagedBean(name="userLoginControler")
@SessionScoped

public class UserLoginControler implements Serializable{

	private static final long serialVersionUID = 1L;
	private User user;
	private UserDao userDao;
	
	
	
	public UserLoginControler() {
		this.userDao = new UserDao();
        this.user = new User();
	}

	public void checkLogin(ActionEvent event){
		
		RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
         
        if(this.userDao.userExist(this.user)) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", user.getLogin());
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }   
		
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
