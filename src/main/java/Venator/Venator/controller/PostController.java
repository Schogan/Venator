package Venator.Venator.controller;

import Venator.Venator.service.GetIdsByName;
import Venator.Venator.service.GetSystemKills;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

  @Autowired public GetIdsByName getIdsByName;
  @Autowired public GetSystemKills getSystemKills;

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
}
