package Venator.Venator.dbRepo;

import Venator.Venator.dbEntity.RegionMappingEntity;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionMappingRepository extends JpaRepository<RegionMappingEntity, Long> {

  RegionMappingEntity findByRegionIdAndConstellationIdAndSystemId(
      Long regionId, Long constellationId, Long systemId);

  RegionMappingEntity findByRegionId(Long regionId);

  ArrayList<RegionMappingEntity> findByRegionName(String regionName);

  RegionMappingEntity findByConstellationId(Long constellationId);

  RegionMappingEntity findBySystemId(Long systemId);
}
