package Venator.Venator.controller;

import Venator.Venator.models.TestModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

  @Autowired public TestModel testModel;
  private static final Log logger = LogFactory.getLog(MainController.class);

  @GetMapping("/getIdsByName")
  public String nameForm(Model model) {
    model.addAttribute("getIdByName", testModel);
    return "testModel";
  }

  @PostMapping("/getIdsByName")
  public String nameSubmit(@ModelAttribute TestModel testModel) {
    this.testModel.setCharacter(testModel.getCharacter());
    this.testModel.setSystem(testModel.getSystem());
    return "result";
  }
}
