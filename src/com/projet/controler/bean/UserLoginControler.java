package com.projet.controler.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.glassfish.jersey.inject.hk2.RequestContext;

import com.projet.dao.UserDao;
import com.projet.model.bean.User;

public class UserLoginControler implements Serializable{

	private static final long serialVersionUID = 1L;
	User user;
	private UserDao userDao;
	
	public void checkLogin(ActionEvent event){
		
		//RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        
		if (userDao.userExist(user)){
			user.setConnected(true);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", user.getLogin());
		}else{
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
        //((Object) context).addCallbackParam("loggedIn", user.isConnected());
		
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
