package zdm.fate.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "map_tiles")
public class Tile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9218570770749733799L;

	@Id
	private Integer id;
	private Integer type;
	private Integer x;
	private Integer y;
	private Integer z;
	private Integer hp;
	private Integer creator;
	private Integer status;
	private String comment;

	@OneToOne(mappedBy = "tile")
	private PlayerStatus player;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Integer getHp() {
		return hp;
	}
	public void setHp(Integer hp) {
		this.hp = hp;
	}
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Tile(Integer id, Integer type, Integer x, Integer y, Integer hp, Integer creator, Integer status, String comment) {
		super();
		this.id = id;
		this.type = type;
		this.x = x;
		this.y = y;
		this.hp = hp;
		this.creator = creator;
		this.status = status;
		this.comment = comment;
	}
	public Tile() {
		super();
	}
	public PlayerStatus getPlayer() {
		return player;
	}
	public void setPlayer(PlayerStatus player) {
		this.player = player;
	}
	public Integer getZ() {
		return z;
	}
	public void setZ(Integer z) {
		this.z = z;
	}

}
