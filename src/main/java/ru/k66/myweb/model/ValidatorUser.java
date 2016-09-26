package ru.k66.myweb.model;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



@Component
public class ValidatorUser  implements Validator {


    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {


        User humanVal = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "Username must not be empty.");
        String name = humanVal.getName();
        if ((name.length()) > 50) {
            errors.rejectValue("name", "name.tooLong", "Username must not more than 50 characters.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "surname.empty", "SU R name must not be empty.");
        String surname = humanVal.getSurname();
        if ((surname.length()) > 50) {
            errors.rejectValue("surname", "surname.tooLong", "Username must not more than 50characters.");
        }


        String car = humanVal.getText();
        if ((car.length()) > 55) {
            errors.rejectValue("car", "car.tooLong", "Car слишком крут ! тест русского текста.");
        }

        String city = humanVal.getText();
        if ((city.length()) > 254) {
            errors.rejectValue("text", "text.tooLong", "Text must not more than 254 characters.");
        }

        /*
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");
        if (!(humanVal.getPassword()).equals(humanVal
                .getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "confirmPassword.passwordDontMatch", "Passwords don't match.");
        }
  */
        if( !EmailValidator.getInstance().isValid( humanVal.getEmail() ) ){
            errors.rejectValue("email", "email.notValid", "Email address is not valid.");
        }

    }


}