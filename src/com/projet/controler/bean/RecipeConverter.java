package com.projet.controler.bean;

import java.util.Map;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.facelets.ConverterConfig;
import javax.faces.view.facelets.FaceletHandler;
import javax.faces.view.facelets.Tag;

import com.projet.model.bean.Recipe;

@FacesConverter(value = "recipeConverter")
public class RecipeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent arg1, String recipeName) {
		System.out.println(recipeName);
//		ValueExpression vex =
//                ctx.getApplication().getExpressionFactory()
//                        .createValueExpression(ctx.getELContext(),
//                                "#{recepiesDaoControler}", RecipesDaoControler.class);
		 Map<String, Object> context = FacesContext.getCurrentInstance().getExternalContext().getApplicationMap();
		 RecipesDaoControler recipesDaoControler = (RecipesDaoControler) context.get("recipesDaoControler");
        return recipesDaoControler.getRecipe(recipeName);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object recipe) {
		return (String)recipe.getClass().getName();
	}
	
	

}
