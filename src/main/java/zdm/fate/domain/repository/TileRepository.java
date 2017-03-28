package zdm.fate.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import zdm.fate.domain.entity.Tile;

@Transactional
public interface TileRepository extends JpaRepository<Tile, Integer> {
	List<Tile> findByXAndYAndZ(Integer x, Integer y, Integer z);
}
