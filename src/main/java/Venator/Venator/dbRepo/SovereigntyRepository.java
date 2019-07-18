package Venator.Venator.dbRepo;

import Venator.Venator.dbEntity.SovereigntyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SovereigntyRepository extends JpaRepository<SovereigntyEntity, Long> {
  SovereigntyEntity findBySystemId(Long systemId);
}
