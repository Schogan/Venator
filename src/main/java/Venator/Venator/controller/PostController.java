package Venator.Venator.controller;

import Venator.Venator.dbEntity.RegionMappingEntity;
import Venator.Venator.dbRepo.RegionMappingRepository;
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

  @Autowired private GetIdsByName getIdsByName;
  @Autowired private GetSystemKills getSystemKills;
  @Autowired private RegionMappingRepository regionMappingRepository;

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

    String regionName;
    Long regionId;
    String constellationName;
    Long constellationId;
    String systemName;
    Long systemId;

    JSONArray jsonArray =
        (JSONArray) readJson("src/main/resources/json_config/RegionMappings.json");
    JSONObject obj;
    JSONParser jsonParser = new JSONParser();
    for (int i = 0; i < jsonArray.size(); i++) {
      obj = (JSONObject) (jsonArray.get(i));
      regionId = Long.parseLong(obj.get("id").toString());
      regionName = obj.get("name").toString();
      JSONObject region = (JSONObject) jsonParser.parse(GetLocationData.getRegion(regionId.toString()));
      JSONArray constellations = (JSONArray) region.get("constellations");
      for (int j = 0; j < constellations.size(); j++) {
        JSONObject constel =
            (JSONObject)
                jsonParser.parse(
                    GetLocationData.getConstellation((constellations.get(j).toString())));
        constellationId = Long.parseLong(constel.get("constellation_id").toString());
        constellationName = constel.get("name").toString();
        JSONArray systems = (JSONArray) constel.get("systems");
        for (int k = 0; k < systems.size(); k++) {

          JSONObject system =
              (JSONObject) jsonParser.parse(GetLocationData.getSystemId(systems.get(k).toString()));
          systemId = Long.parseLong(system.get("system_id").toString());
          systemName = system.get("name").toString();
          System.out.println(regionId+" /// "+regionName+" /// "+constellationId+" /// "+constellationName+" /// "+systemId+" /// "+systemName);
          RegionMappingEntity RME = new RegionMappingEntity();
          RME.setRegionId(regionId);
          RME.setRegionName(regionName);
          RME.setConstellationId(constellationId);
          RME.setConstellationName(constellationName);
          RME.setSystemId(systemId);
          RME.setSystemName(systemName);

          regionMappingRepository.save(RME);

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
