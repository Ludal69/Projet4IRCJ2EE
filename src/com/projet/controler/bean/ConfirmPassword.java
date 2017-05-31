package com.projet.controler.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class ConfirmPassword implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String submittedValue;
	private String confirmedValue;
	
	public ConfirmPassword(){
		
	}
	
	

	public ConfirmPassword(String submittedValue, String confirmedValue) {
		this.submittedValue = submittedValue;
		this.confirmedValue = confirmedValue;
	}



	public String getSubmittedValue() {
		return submittedValue;
	}

	public void setSubmittedValue(String submittedValue) {
		this.submittedValue = submittedValue;
	}

	public String getConfirmedValue() {
		return confirmedValue;
	}

	public void setConfirmedValue(String confirmedValue) {
		this.confirmedValue = confirmedValue;
	}
	
	

}
