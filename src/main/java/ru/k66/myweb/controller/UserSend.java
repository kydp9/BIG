package ru.k66.myweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.k66.myweb.model.User;

import ru.k66.myweb.model.ValidatorUser;
import ru.k66.myweb.service.UserService;

import java.util.Map;


@Controller
public class UserSend  {

    @Autowired
    private ValidatorUser validatorTest;


    @Autowired
    private UserService userService;

    @RequestMapping("/usersend")
    public String setupForm(Map<String,Object> map){

        User user = new User();
        user.setUserId(0);
        map.put("user",user);
        map.put("userList", userService.getAllUsers());
        return "usersend";
    }




    @RequestMapping (value = "/usersend.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute User user, BindingResult result, @RequestParam String action, Map<String,Object> map ) {



        User userResult = new User();

user.setUserId(0);


        switch (action.toLowerCase()){
            case "send":
                validatorTest.validate(user, result);
                if (result.hasErrors()) {

                    map.put("user", user);
                    map.put("userList", userService.getAllUsers());
                    return "usersend";

                }
                userService.add(user);
                userResult = user;
                break;


            case "search":
                userResult = user;
                map.put("user",userResult);
                map.put("userList", userService.seatchUser(user));
                return "usersend";

        }
        map.put("user",userResult);
        map.put("userList", userService.getAllUsers());
        return "usersend";
    }
}

