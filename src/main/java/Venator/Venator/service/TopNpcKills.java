package Venator.Venator.service;

import Venator.Venator.dbEntity.RegionMappingEntity;
import Venator.Venator.dbEntity.SystemKillsEntity;
import Venator.Venator.dbRepo.RegionMappingRepository;
import Venator.Venator.dbRepo.SystemKillsRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TopNpcKills {
    @Autowired
    private RegionMappingRepository regionMappingRepository;
    @Autowired private SystemKillsRepository systemKillsRepository;
    private static final Log logger = LogFactory.getLog(ProcessFormSelection.class);
    private String systemName;
    private Long npcKills;

    public Map<String, Long> getTopNpcKills(ArrayList<Long> contellationId) {
        Map<String, Long> npcKillsMap = new HashMap<>();
        ArrayList<Long> sysIDs = new ArrayList<>();
        for (Long constID : contellationId) {
            ArrayList<RegionMappingEntity> constInfo =
                    regionMappingRepository.findByConstellationId(constID);
            for (RegionMappingEntity systemInConst : constInfo) {
                sysIDs.add(systemInConst.getSystemId());
            }
        }
        for (Long sysID : sysIDs) {
            this.systemName = regionMappingRepository.findBySystemId(sysID).getSystemName();
            SystemKillsEntity killsEntity = systemKillsRepository.findBySystemId(sysID);
            if (killsEntity == null) {
                this.npcKills=0L;
            } else {
                this.npcKills=killsEntity.getNpcKills();
            }
            npcKillsMap.put(systemName, npcKills);
        }
        LinkedHashMap<String, Long> reverseSortedMap = new LinkedHashMap<>();
        //Use Comparator.reverseOrder() for reverse ordering
        npcKillsMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        logger.info(reverseSortedMap);
        return reverseSortedMap;
    }
}
