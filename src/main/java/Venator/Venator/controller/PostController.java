package Venator.Venator.controller;

import Venator.Venator.service.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

  @Autowired private GetIdsByName getIdsByName;
  @Autowired private GetSystemKills getSystemKills;
  @Autowired private RefreshDirectory refreshDirectory;

  @RequestMapping("/getIdsByNamePost")
  public String getIdsByNamePost() throws IOException {
    String results = getIdsByName.getIdsByName();
    return results;
  }

  @RequestMapping("/getSystemKills")
  public String getSystemKillsPost() throws IOException, ParseException {
    String results = getSystemKills.getSystemKills();
    return results;
  }

  // This endpoint is used to refresh the Region mapping table use table to export a new CSV file
  // after running
  @RequestMapping("/directoryRefresh")
  public String directoryRefresh() throws Exception {

    refreshDirectory.refreshDirectory();

    return "!!!!!HUZZAH IT DIDN'T BLOW UP!!!!!";
  }
}
