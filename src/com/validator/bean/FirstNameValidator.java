package com.validator.bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "validators.firstName")
public class FirstNameValidator implements Validator {

	private static final String FIRST_NAME_PATTERN = "^[_A-Za-z]+";
	private Pattern pattern;
	private Matcher matcher;

	public FirstNameValidator() {
		pattern = Pattern.compile(FIRST_NAME_PATTERN);
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		matcher = pattern.matcher(value.toString());
		if (!matcher.matches()) {
			FacesMessage msg = new FacesMessage("First Name validation failed.",
					"First Name Validation failed please follow the contraint" + FIRST_NAME_PATTERN);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

}

