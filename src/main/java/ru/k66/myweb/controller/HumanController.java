package ru.k66.myweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.k66.myweb.model.Human;
import ru.k66.myweb.model.Validator103;
import ru.k66.myweb.service.HumanService;

import java.util.Map;

/**
 * Created by ikydp on 02.09.2016.
 */

@Controller
public class HumanController {


    @Autowired
    private Validator103 validatorTest;

    @Qualifier("humanServiceimpl")
    @Autowired
    private HumanService humanService;

    @RequestMapping("/humanAlfa")
    public String setupForm(Map<String,Object> map){

        Human human = new Human();
        map.put("human",human);
        map.put("humanList",humanService.getAllHumans());
        return "human";
    }




    @RequestMapping (value = "/human.do", method = RequestMethod.POST)
public String doActions(@ModelAttribute Human human, BindingResult result,@RequestParam String action, Map<String,Object> map ) {
    Human humanResult = new Human();




        switch (action.toLowerCase()){
            case "add":
                validatorTest.validate(human, result);
                if (result.hasErrors()) {

                    map.put("human",human);
                    map.put("humanList", humanService.getAllHumans());
                    return "humanFind";

                }
                humanService.add(human);
                humanResult = human;
                break;
            case "edit":
                validatorTest.validate(human, result);
                if (result.hasErrors()) {

                    map.put("human",human);
                    map.put("humanList", humanService.getAllHumans());
                    return "humanFind";

                }
                humanService.edit(human);
                humanResult = human;
                break;
            case "delete":
                humanService.delete(human.getId());
                humanResult =  new Human();
                break;
            case "search":
                Human searchedHuman = humanService.getHuman(human.getId());

                humanResult = searchedHuman != null ?  searchedHuman : new Human();
                break;
        }
        map.put("human",humanResult);
        map.put("humanList",humanService.getAllHumans());
        return "human";
}
}
