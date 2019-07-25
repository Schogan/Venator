package Venator.Venator.service;

import Venator.Venator.dbEntity.RegionMappingEntity;
import Venator.Venator.dbEntity.SystemJumpsEntity;
import Venator.Venator.dbEntity.SystemKillsEntity;
import Venator.Venator.dbRepo.RegionMappingRepository;
import Venator.Venator.dbRepo.SystemJumpsRepository;
import Venator.Venator.dbRepo.SystemKillsRepository;
import Venator.Venator.models.SystemData;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessFormSelection {

  @Autowired public RegionMappingRepository regionMappingRepository;
  @Autowired public SystemKillsRepository systemKillsRepository;
  @Autowired public SystemJumpsRepository systemJumpsRepository;
  private static final Log logger = LogFactory.getLog(ProcessFormSelection.class);

  ArrayList<SystemData> systemDataList = new ArrayList<>();

  public void processFormSelection(String[] regionselection) {



    for (String regionselected : regionselection) {
      ArrayList<RegionMappingEntity> newMap =
          regionMappingRepository.findByRegionName(regionselected);
      for (RegionMappingEntity entity : newMap) {
        SystemKillsEntity killsEntity = systemKillsRepository.findBySystemId(entity.getSystemId());
        SystemJumpsEntity jumpsEntity = systemJumpsRepository.findBySystemId(entity.getSystemId());
        Long npcKills;
        Long podKills;
        Long shipKills;
        Long jumps;

        if (killsEntity == null) {
          npcKills = 0L;
          podKills = 0L;
          shipKills = 0L;
        } else {
          npcKills = killsEntity.getNpcKills();
          podKills = killsEntity.getPodKills();
          shipKills = killsEntity.getShipKills();
        }

        if (jumpsEntity == null) {
          jumps = 0L;
        } else {
          jumps = jumpsEntity.getShipJumps();
        }

        systemDataList.add(
            new SystemData(
                regionselected,
                entity.getConstellationName(),
                entity.getSystemName(),
                entity.getSystemId(),
                npcKills,
                podKills,
                shipKills,
                jumps));
      }
    }
    for (SystemData systemData : systemDataList) {
      logger.info(systemData.toString());
    }
  }

  public ArrayList getSystemDataList(){
    return systemDataList;
  }
}
