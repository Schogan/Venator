package Venator.Venator.dbRepo;

import Venator.Venator.dbEntity.RegionMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionMappingRepository extends JpaRepository<RegionMappingEntity, Long> {

        public RegionMappingEntity findByRegionIdAndConstellationIdAndSystemId(Long regionId,
                                                                      Long constellationId,
                                                                      Long systemId);
        public RegionMappingEntity findByRegionId(Long regionId);

        public RegionMappingEntity findByConstellationId(Long constellationId);

        public RegionMappingEntity findBySystemId(Long systemId);
}
