package ru.k66.myweb.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by ikydp on 04.09.2016.
 */
@Component
public class Validator103  implements Validator{


    public boolean supports(Class<?> clazz) {
        return Human.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
  
        Human humanVal = (Human) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "Username must not be empty.");
        String name = humanVal.getName();
        if ((name.length()) > 16) {
            errors.rejectValue("name", "name.tooLong", "Username must not more than 16 characters.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "surname.empty", "SU R name must not be empty.");
        String surname = humanVal.getSurname();
        if ((surname.length()) > 216) {
            errors.rejectValue("surname", "surname.tooLong", "Username must not more than 244 characters.");
        }


        String car = humanVal.getCar();
        if ((car.length()) > 55) {
            errors.rejectValue("car", "car.tooLong", "Car слишком крут ! тест русского текста.");
        }

        String city = humanVal.getCity();
        if ((city.length()) > 106) {
            errors.rejectValue("city", "city.tooLong", "City must not more than 244 characters.");
        }

        /*
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "Password must not be empty.");
        if (!(humanVal.getPassword()).equals(humanVal
                .getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "confirmPassword.passwordDontMatch", "Passwords don't match.");
        }

        if( !EmailValidator.getInstance().isValid( humanVal.getEmail() ) ){
            errors.rejectValue("email", "email.notValid", "Email address is not valid.");
        }
       */
    }

    /**
     * Created by ikydp on 05.09.2016.
     */

}