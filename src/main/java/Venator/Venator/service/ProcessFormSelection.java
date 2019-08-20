package Venator.Venator.service;

import Venator.Venator.dbEntity.RegionMappingEntity;
import Venator.Venator.dbRepo.RegionMappingRepository;
import Venator.Venator.models.ConstellationData;
import java.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessFormSelection {
  @Autowired private RegionMappingRepository regionMappingRepository;
  @Autowired private ConstellationData constellationData;
  @Autowired private TopNpcKills topNpcKills;
  private static final Log logger = LogFactory.getLog(ProcessFormSelection.class);
  private Map<String, Map> regionSelectionMap = new HashMap<>();
  private Map<String, Long> topNpcKillsMap = new HashMap<>();

  public void processFormSelection(String[] regionSelection) {
    regionSelectionMap = new HashMap<>();
    for (String regionSelected : regionSelection) {
      ArrayList<RegionMappingEntity> allEntries =
          regionMappingRepository.findByRegionName(regionSelected);
      ArrayList<Long> constIDs = new ArrayList<>();
      for (RegionMappingEntity nextEntry : allEntries) {
        constIDs.add(nextEntry.getConstellationId());
      }
      LinkedHashSet<Long> hashSet = new LinkedHashSet<>(constIDs);
      ArrayList<Long> newConstIds = new ArrayList<>(hashSet);
      topNpcKillsMap = topNpcKills.getTopNpcKills(newConstIds);
      regionSelectionMap.put(regionSelected, constellationData.getConstellationData(newConstIds));
    }
    logger.info(regionSelectionMap.toString());
  }

  public Map<String, Map> getSystemDataList() {
    return regionSelectionMap;
  }

  public Map<String, Long> getTopNpcKillsMap() {
    return topNpcKillsMap;
  }
}
