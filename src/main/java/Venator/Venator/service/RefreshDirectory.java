package Venator.Venator.service;

import Venator.Venator.dbEntity.RegionMappingEntity;
import Venator.Venator.dbRepo.RegionMappingRepository;
import java.io.FileReader;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RefreshDirectory {

  @Autowired GetRegionMapData getRegionMapData;
  @Autowired private RegionMappingRepository regionMappingRepository;
  private static final Log logger = LogFactory.getLog(RefreshDirectory.class);

  public void refreshDirectory() throws Exception {
    String regionName;
    Long regionId;
    String constellationName;
    Long constellationId;
    String systemName;
    Long systemId;
    FileReader reader = new FileReader("src/main/resources/json_config/RegionMappings.json");
    JSONParser jsonParser = new JSONParser();

    regionMappingRepository.deleteAll();

    JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
    JSONObject obj;
    for (int i = 0; i < jsonArray.size(); i++) {
      obj = (JSONObject) (jsonArray.get(i));
      regionId = Long.parseLong(obj.get("id").toString());
      regionName = obj.get("name").toString();
      JSONObject region =
          (JSONObject) jsonParser.parse(getRegionMapData.getRegion(regionId.toString()));
      JSONArray constellations = (JSONArray) region.get("constellations");
      for (int j = 0; j < constellations.size(); j++) {
        JSONObject constel =
            (JSONObject)
                jsonParser.parse(
                    getRegionMapData.getConstellation((constellations.get(j).toString())));
        constellationId = Long.parseLong(constel.get("constellation_id").toString());
        constellationName = constel.get("name").toString();
        JSONArray systems = (JSONArray) constel.get("systems");
        for (int k = 0; k < systems.size(); k++) {

          JSONObject system =
              (JSONObject)
                  jsonParser.parse(getRegionMapData.getSystemId(systems.get(k).toString()));
          systemId = Long.parseLong(system.get("system_id").toString());
          systemName = system.get("name").toString();
          logger.info(
              regionId
                  + " /// "
                  + regionName
                  + " /// "
                  + constellationId
                  + " /// "
                  + constellationName
                  + " /// "
                  + systemId
                  + " /// "
                  + systemName);
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
  }
}
