package zdm.fate.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zdm.fate.common.constant.BaseRule;
import zdm.fate.domain.entity.PlayerStatus;
import zdm.fate.domain.entity.SysUser;
import zdm.fate.domain.entity.Tile;
import zdm.fate.domain.repository.PlayerStatusRepository;
import zdm.fate.domain.repository.TileRepository;
import zdm.fate.service.TileService;

@Service
public class TileServiceImpl implements TileService {
	@Autowired
	TileRepository tileRepository;
	@Autowired
	PlayerStatusRepository playerStatusRepository;

	@Override
	public List<List<Tile>> getMap(SysUser user) {
		PlayerStatus playerStatus = playerStatusRepository.findOne(user.getId());
		Tile tile = playerStatus.getTile();
		if (tile == null) throw new NullPointerException("玩家不存在世界中！");
		return getMap(tile.getX(), tile.getY(), tile.getZ(), playerStatus.getSight());
	}

	@Override
	public List<List<Tile>> getMap(Integer x, Integer y, Integer z, Integer sight) {

		List<List<Tile>> mapList = new ArrayList<List<Tile>>();
		for (int i = -sight, j; i <= sight; i++)
			for (j = -sight; j <= sight; j++)
				mapList.add(tileRepository.findByXAndYAndZ(x + i, y + j, z));
		return mapList;
	}

	@Override
	public void setRandomTileXY(Tile tile) {
		tile.setX((int) (Math.random() * BaseRule.MAP_WIDTH));
		tile.setY((int) (Math.random() * BaseRule.MAP_HEIGHT));
	}

	@Override
	public void setRandomTileZ(Tile tile) {
		tile.setZ((int) (Math.random() * BaseRule.MAP_WORLD));
	}
}
