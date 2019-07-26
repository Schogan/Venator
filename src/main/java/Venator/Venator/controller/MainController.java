package Venator.Venator.controller;

import Venator.Venator.models.RegionSelectModel;
import Venator.Venator.service.ProcessFormSelection;
import java.util.Map;
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

  @Autowired private RegionSelectModel regionSelectModel;
  @Autowired private ProcessFormSelection processFormSelection;
  private static final Log logger = LogFactory.getLog(MainController.class);

  @GetMapping("/processSelection")
  public String processForm(Model model) {
    model.addAttribute("processForm", regionSelectModel);
    return "processForm";
  }

  @PostMapping("/processSelection")
  public String processSubmit(@ModelAttribute RegionSelectModel regionSelectModel) {
    this.regionSelectModel.setMultiCheckboxSelectedValues(
        regionSelectModel.getMultiCheckboxSelectedValues());
    processFormSelection.processFormSelection(regionSelectModel.getMultiCheckboxSelectedValues());
    return "redirect:processResult";
  }

  @GetMapping("/processResult")
  public String regionResults(Model model) {
    Map<String, Map> systemDataList = processFormSelection.getSystemDataList();
    model.addAttribute("processResult", systemDataList);
    return "processResult";
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
