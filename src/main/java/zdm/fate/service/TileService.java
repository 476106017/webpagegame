package zdm.fate.service;

import java.util.List;

import zdm.fate.domain.entity.SysUser;
import zdm.fate.domain.entity.Tile;

public interface TileService {
	public List<List<Tile>> getMap(SysUser user);
	public List<List<Tile>> getMap(Integer x, Integer y, Integer z, Integer sight);
	public void setRandomTileXY(Tile tile);
	public void setRandomTileZ(Tile tile);

}
