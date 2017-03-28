package zdm.fate.domain.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "player_status")
public class PlayerStatus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6395442457266546940L;

	@Id
	private Integer id;
	private Integer red;
	private Integer max;
	private Integer blue;
	private String buffs;

	@OneToOne(cascade = CascadeType.PERSIST)
	private Tile tile;
	private Integer sight;

	public PlayerStatus() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRed() {
		return red;
	}

	public void setRed(Integer red) {
		this.red = red;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getBlue() {
		return blue;
	}

	public void setBlue(Integer blue) {
		this.blue = blue;
	}

	public String getBuffs() {
		return buffs;
	}

	public void setBuffs(String buffs) {
		this.buffs = buffs;
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public Integer getSight() {
		return sight;
	}

	public void setSight(Integer sight) {
		this.sight = sight;
	}

	public PlayerStatus(Integer id, Integer red, Integer max, Integer blue, String buffs, Tile tile, Integer sight) {
		super();
		this.id = id;
		this.red = red;
		this.max = max;
		this.blue = blue;
		this.buffs = buffs;
		this.tile = tile;
		this.sight = sight;
	}



}
