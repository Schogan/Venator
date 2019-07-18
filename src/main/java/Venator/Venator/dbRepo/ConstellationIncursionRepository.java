package Venator.Venator.dbRepo;

import Venator.Venator.dbEntity.ConstellationIncursionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstellationIncursionRepository extends JpaRepository<ConstellationIncursionEntity, Long> {
    ConstellationIncursionEntity findByConstellationId(Long constellationId);
}
