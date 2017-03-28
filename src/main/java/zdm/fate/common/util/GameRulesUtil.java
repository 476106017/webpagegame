package zdm.fate.common.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zdm.fate.domain.entity.Tile;
import zdm.fate.service.TileService;

public class GameRulesUtil {
	@Autowired
	TileService tileService;

	public void resetTiles(List<Tile> tiles) {
		for (Tile tile : tiles) {
			tileService.setRandomTileXY(tile);
		}
	}
}
