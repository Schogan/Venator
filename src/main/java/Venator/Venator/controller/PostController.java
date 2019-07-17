package Venator.Venator.controller;

import Venator.Venator.service.*;
import java.io.IOException;
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
  public String getSystemKillsPost() throws IOException {
    String results = getSystemKills.getSystemKills();
    return results;
  }

  @RequestMapping("/directoryRefresh")
  public String directoryRefresh() throws Exception {

    refreshDirectory.refreshDirectory();

    return "I guess it worked";
  }
}
