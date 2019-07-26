package Venator.Venator.models;

import Venator.Venator.dbEntity.SystemJumpsEntity;
import Venator.Venator.dbEntity.SystemKillsEntity;
import Venator.Venator.dbRepo.RegionMappingRepository;
import Venator.Venator.dbRepo.SystemJumpsRepository;
import Venator.Venator.dbRepo.SystemKillsRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SystemData {

  @Autowired private RegionMappingRepository regionMappingRepository;
  @Autowired private SystemKillsRepository systemKillsRepository;
  @Autowired private SystemJumpsRepository systemJumpsRepository;
  @Autowired private SystemMetaData systemMetaData;

  public Map<String, ArrayList> getSystemData(ArrayList<Long> systemId) {
    Map<String, ArrayList> systemDataMap = new HashMap<>();
    for (Long sysID : systemId) {
      String systemName = regionMappingRepository.findBySystemId(sysID).getSystemName();
      SystemKillsEntity killsEntity = systemKillsRepository.findBySystemId(sysID);
      SystemJumpsEntity jumpsEntity = systemJumpsRepository.findBySystemId(sysID);

      if (killsEntity == null) {
        systemMetaData.setNpcKills(0L);
        systemMetaData.setPodKills(0L);
        systemMetaData.setShipKills(0L);
      } else {
        systemMetaData.setNpcKills(killsEntity.getNpcKills());
        systemMetaData.setPodKills(killsEntity.getPodKills());
        systemMetaData.setShipKills(killsEntity.getShipKills());
      }

      if (jumpsEntity == null) {
        systemMetaData.setJumps(0L);
      } else {
        systemMetaData.setJumps(jumpsEntity.getShipJumps());
      }
      ArrayList systemInfo = systemMetaData.getSystemMetaData();
      systemDataMap.put(systemName, systemInfo);
    }
    return systemDataMap;
  }
}
