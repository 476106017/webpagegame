package zdm.fate.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import zdm.fate.domain.entity.PlayerStatus;

@Transactional
public interface PlayerStatusRepository extends CrudRepository<PlayerStatus, Integer> {

}
