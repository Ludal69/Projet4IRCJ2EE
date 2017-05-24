package com.projet.model.bean;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped

public class Comment implements Serializable{
	private static final long serialVersionUID = 1L;
	private String content;
	private long user_id;
	private long recipe_id;
	
	public Comment() {
	}

	public Comment(String content, long user_id, long recipe_id) {
		super();
		this.content = content;
		this.user_id = user_id;
		this.recipe_id = recipe_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(long recipe_id) {
		this.recipe_id = recipe_id;
	}
}
