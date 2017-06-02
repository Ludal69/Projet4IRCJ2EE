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
//@Named
@SessionScoped

public class UserLoginControler implements Serializable{

	private static final long serialVersionUID = 1L;
	User user;
	private UserDao userDao;
	
	
	
	public UserLoginControler() {
		this.userDao = new UserDao();
        this.user = new User();
	}

	public void checkLogin(ActionEvent event){
		
		RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        
		if (userDao.userExist(user)){
			user.setConnected(true);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", user.getLogin());
		}else{
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
        ((RequestContext) context).addCallbackParam("loggedIn", user.isConnected());
		
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
