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
public class FindSomeController {
    @Autowired
    private Validator103 validatorTest;


    @Qualifier("humanFindServiceImpl")
    @Autowired

    private HumanService humanFindService;

    @RequestMapping("/search")
    public String setupForm(Map<String,Object> map){

        Human human = new Human();
        map.put("human",human);

        return "findData";
    }




    @RequestMapping (value = "/search.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Human human, BindingResult result , @RequestParam String action, Map<String,Object> map )
    {
        Human humanResult = new Human();




        switch (action.toLowerCase()){

            case "search":
                humanResult = human;
                map.put("human",humanResult);
                map.put("humanList", humanFindService.searchHumans(human));
                return "findData";
        }
        map.put("human",humanResult);

        return "findData";


}

    }