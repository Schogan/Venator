package Venator.Venator.controller;

import Venator.Venator.service.GetIdsByName;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

  @Autowired public GetIdsByName getIdsByName;

  @RequestMapping("/getIdsByNamePost")
  public String jsonString() throws IOException {
    //    List names = Arrays.asList(checkboxValue);

    String results = getIdsByName.getIdsByName();
    return results;
  }
}
