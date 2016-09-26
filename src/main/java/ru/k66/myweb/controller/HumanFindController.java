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



@Controller
public class HumanFindController {
    @Autowired
    private Validator103 validatorTest;

    @Qualifier("humanFindServiceImpl")
    @Autowired

    private HumanService humanFindService;

    @RequestMapping("/find")
    public String setupForm(Map<String,Object> map){

        Human human = new Human();
        map.put("human",human);
        map.put("humanList", humanFindService.getAllHumans());
        return "humanFind";
    }




    @RequestMapping (value = "/find.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Human human, BindingResult result ,  @RequestParam String action, Map<String,Object> map   ) {
        Human humanResult = new Human();





        switch (action.toLowerCase()){
            case "add":
                validatorTest.validate(human, result);
                if (result.hasErrors()) {
                    map.put("human",human);
                    map.put("humanList", humanFindService.getAllHumans());
                    return "humanFind";
                }
                humanFindService.add(human);
                humanResult = human;
                break;
            case "edit":
                validatorTest.validate(human, result);
                if (result.hasErrors()) {
                    map.put("human",human);
                    map.put("humanList", humanFindService.getAllHumans());
                    return "humanFind";
                }
                humanFindService.edit(human);
                humanResult = human;
                break;
            case "delete":
                humanFindService.delete(human.getId());
                humanResult =  new Human();
                break;
            case "search":
                humanResult = human;
                map.put("human",humanResult);
                map.put("humanList", humanFindService.searchHumans(human));
                return "humanFind";
            case "getid":

                Human searchedHuman = humanFindService.getHuman(human.getId());

                humanResult = searchedHuman != null ?  searchedHuman : new Human();
                break;

        }
        map.put("human",humanResult);
        map.put("humanList", humanFindService.getAllHumans());
        return "humanFind";
    }



}
