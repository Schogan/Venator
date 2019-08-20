package Venator.Venator.controller;

import Venator.Venator.models.RegionSelectModel;
import Venator.Venator.service.GetRegionNames;
import Venator.Venator.service.ProcessFormSelection;

import java.io.IOException;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.parser.ParseException;
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
  @Autowired private GetRegionNames getRegionNames;
  private static final Log logger = LogFactory.getLog(MainController.class);

  @GetMapping("/processSelection")
  public String processForm(Model model) {
    model.addAttribute("processForm", regionSelectModel);
    regionSelectModel.resetMultiCheckboxSelectedValues();
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
    Map<String, Long> topNpcKillsMap = processFormSelection.getTopNpcKillsMap();
    model.addAttribute("processResult", systemDataList);
    model.addAttribute("npcKills", topNpcKillsMap);
    return "processResult";
  }

  @ModelAttribute("multiCheckboxAllValues")
  public String[] getMultiCheckboxAllValues() throws IOException, ParseException {
    String[] checkbox = getRegionNames.GetRegionNames().toArray(new String[]{});
    return checkbox;
  }
}
