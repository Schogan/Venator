package Venator.Venator.controller;

import Venator.Venator.service.*;
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
        (JSONArray) readJson("src/main/resources/json_config/RegionMappings.json");
    JSONObject obj;
    JSONParser jsonParser = new JSONParser();
    for (int i = 0; i < jsonArray.size(); i++) {
      obj = (JSONObject) (jsonArray.get(i));
      String regionId = obj.get("id").toString();
      JSONObject region = (JSONObject) jsonParser.parse(GetLocationData.getRegion(regionId));
      JSONArray constellations = (JSONArray) region.get("constellations");
      for (int j = 0; j < constellations.size(); j++) {
        JSONObject constel =
            (JSONObject)
                jsonParser.parse(
                    GetLocationData.getConstellation((constellations.get(j).toString())));
        JSONArray systems = (JSONArray) constel.get("systems");
        for (int k = 0; k < systems.size(); k++) {

          JSONObject system =
              (JSONObject) jsonParser.parse(GetLocationData.getSystemId(systems.get(k).toString()));
          String systemId = system.get("system_id").toString();
          String systemName = system.get("name").toString();
        }
      }
    }

    return "I guess it worked";
  }

  public static Object readJson(String filename) throws Exception {
    FileReader reader = new FileReader(filename);
    JSONParser jsonParser = new JSONParser();
    return jsonParser.parse(reader);
  }
}
