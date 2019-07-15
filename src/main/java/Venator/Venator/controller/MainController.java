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
    this.testModel.setMultiCheckboxSelectedValues(testModel.getMultiCheckboxSelectedValues());
    return "result";
  }

  @ModelAttribute("multiCheckboxAllValues")
  public String[] getMultiCheckboxAllValues() {
    return new String[] {
      "Black Rise",
      "Catch",
      "Cloud Ring",
      "Cobalt Edge",
      "Delve",
      "Derelik",
      "Devoid",
      "Domain",
      "Esoteria",
      "Essence",
      "Etherium Reach",
      "Everyshore",
      "Feythabolis",
      "Fountain",
      "Genesis",
      "Great Wildlands",
      "Heimatar",
      "Immensea",
      "Kador",
      "Kalevala Expanse",
      "Khanid",
      "Kor-Azor",
      "Lonetrek",
      "Malpais",
      "Metropolis",
      "Molden Heath",
      "Oasa",
      "Outer Passage",
      "Outer Ring",
      "Period Basis",
      "Perrigen Falls",
      "Placid",
      "Querious",
      "Sinq Laison",
      "Solitude",
      "Spire",
      "Stain",
      "Syndicate",
      "Tash Murkon",
      "Tenal",
      "The Bleak Lands",
      "The Forge",
      "Vale of the Silent",
      "Wicked Creek",
      "Miscellaneous Entries"
    };
  }
}
