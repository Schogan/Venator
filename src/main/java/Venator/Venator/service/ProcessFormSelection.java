package Venator.Venator.service;

import Venator.Venator.dbEntity.RegionMappingEntity;
import Venator.Venator.dbRepo.RegionMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessFormSelection {

    @Autowired RegionMappingRepository regionMappingRepository;

    public void processFormSelection(String[] regionselection){
        for(String regionselected: regionselection){
            RegionMappingEntity newMap = regionMappingRepository.findByRegionName(regionselected);



        }
    }
}
