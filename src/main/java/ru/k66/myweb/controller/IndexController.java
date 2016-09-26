package ru.k66.myweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {




    @RequestMapping("/index")
    public String setupForm(){


        return "index";
    }




    @RequestMapping (value = "/index.do", method = RequestMethod.POST)
    public String doActions( @RequestParam String action ) {





        switch (action.toLowerCase()){
            case "humanfind":
            {
                    return  "forward:/find";

                }

            case "usersend":

                    return "redirect:/usersend";



            case "weather":
               return  "redirect:/weather";

            case "weatherjson":
return "forward:/gsonweather";

        }

        return "index";
    }
}