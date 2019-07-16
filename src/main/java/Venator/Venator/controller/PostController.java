package Venator.Venator.controller;

import Venator.Venator.service.GetIdsByName;
import Venator.Venator.service.GetSystemKills;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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

  @RequestMapping("/directory")
  public String directory() throws Exception {

    JSONArray jsonArray =
        (JSONArray) readJsonSimpleDemo("src/main/resources/json_config/RegionMappings.json");
    JSONObject obj;

    for (int i = 0; i < jsonArray.size(); i++) {
      obj = (JSONObject) (jsonArray.get(i));
      String regionId = obj.get("id").toString();


    }



    return "I guess it worked";
  }

  public static Object readJsonSimpleDemo(String filename) throws Exception {
    FileReader reader = new FileReader(filename);
    JSONParser jsonParser = new JSONParser();
    return jsonParser.parse(reader);
  }
}
