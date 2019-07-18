package Venator.Venator.dbRepo;

import Venator.Venator.dbEntity.SystemJumpsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemJumpsRepository extends JpaRepository<SystemJumpsEntity, Long> {

  SystemJumpsEntity findBySystemId(Long systemId);
}
