package Venator.Venator.dbRepo;

import Venator.Venator.dbEntity.SystemKillsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemKillsRepository extends JpaRepository<SystemKillsEntity, Long> {

    SystemKillsEntity findBySystemId(Long systemId);
}
