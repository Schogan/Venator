package Venator.Venator.models;

import Venator.Venator.dbEntity.RegionMappingEntity;
import Venator.Venator.dbRepo.RegionMappingRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstellationData {
  @Autowired private RegionMappingRepository regionMappingRepository;
  @Autowired private SystemData systemData;
  private String constellationName;

  public Map<String, Map> getConstellationData(ArrayList<Long> contellationId) {
    Map<String, Map> constellationMap = new HashMap<>();
    for (Long constID : contellationId) {
      ArrayList<RegionMappingEntity> constInfo =
          regionMappingRepository.findByConstellationId(constID);
      ArrayList<Long> sysIDs = new ArrayList<>();
      for (RegionMappingEntity systemInConst : constInfo) {
        this.constellationName = systemInConst.getConstellationName();
        sysIDs.add(systemInConst.getSystemId());
      }
      constellationMap.put(constellationName, systemData.getSystemData(sysIDs));
    }
    return constellationMap;
  }
}
