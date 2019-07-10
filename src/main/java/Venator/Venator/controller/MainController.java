package Venator.Venator.controller;

import Venator.Venator.models.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    public TestModel testModel;

    @GetMapping("/getIdsByName")
    public String nameForm(Model model){
        model.addAttribute("getIdByName", new TestModel());
        return "testModel";
    }

    @PostMapping("/getIdsByName")
    public String nameSubmit(@ModelAttribute TestModel testModel){
        return "result";
    }

        //populate this through some user interface


}
