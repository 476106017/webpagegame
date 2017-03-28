package zdm.fate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zdm.fate.common.config.IllegalDataIntegrityException;
import zdm.fate.common.constant.Buff;
import zdm.fate.domain.entity.PlayerStatus;
import zdm.fate.domain.entity.SysUser;
import zdm.fate.domain.repository.PlayerStatusRepository;
import zdm.fate.service.PlayerStatusService;

@Service
public class PlayerStatusServiceImpl implements PlayerStatusService {
	@Autowired
	PlayerStatusRepository playerStatusRepository;

	public int[] hpBar(SysUser user) throws IllegalDataIntegrityException {
		PlayerStatus playerStatus = playerStatusRepository.findOne(user.getId());
		int red = playerStatus.getRed();
		int blank = playerStatus.getMax() - red;
		int blue = playerStatus.getBlue();
		if (red < 0 || blank < 0 || blue < 0 || red + blank + blue > 12)
			throw new IllegalDataIntegrityException("血量有误！");
		if (red > 6)
			return new int[]{6, 0, 0, red - 6, blank, blue};
		else if (red + blank > 6)
			return new int[]{red, 6 - red, 0, 0, blank + red - 6, blue};
		else if (red + blank + blue > 6)
			return new int[]{red, blank, 6 - red - blank, 0, 0, blue + blank + red - 6};
		else
			return new int[]{red, blank, blue, 0, 0, 0};
	}

	public void createStatus(SysUser user) {
		PlayerStatus playerStatus;
		if (user.getRole().equals("ROLE_ADMIN"))
			playerStatus = new PlayerStatus(user.getId(), 0, 0, 12, Buff.THIRTEENTH.getStr(), null, 5);
		else if (user.getRole().equals("ROLE_USER"))
			playerStatus = new PlayerStatus(user.getId(), 3, 3, 0, Buff.ANONYMOUS.getStr(), null, 2);
		else
			playerStatus = new PlayerStatus();
		playerStatusRepository.save(playerStatus);
	}

	public String addBuffs(SysUser user, Buff[] buffs) {
		PlayerStatus playerStatus = playerStatusRepository.findOne(user.getId());
		String newBuffs = playerStatus.getBuffs();
		for (Buff buff : buffs) {
			if (!new String(" " + newBuffs + " ").contains(" " + buff.getStr() + " "))
				newBuffs += " " + buff.getStr();
		}
		playerStatus.setBuffs(newBuffs.trim());
		playerStatusRepository.save(playerStatus);
		return newBuffs;
	}

	public String removeBuffs(SysUser user, Buff[] buffs) {
		PlayerStatus playerStatus = playerStatusRepository.findOne(user.getId());
		String newBuffs = playerStatus.getBuffs();
		for (Buff buff : buffs) {
			newBuffs = newBuffs.replace(buff.getStr() + " ", "");
			newBuffs = newBuffs.replace(buff.getStr(), "");
		}
		playerStatus.setBuffs(newBuffs.trim());
		playerStatusRepository.save(playerStatus);
		return newBuffs;
	}

	public String[] findBuffs(SysUser user) {
		PlayerStatus playerStatus = playerStatusRepository.findOne(user.getId());
		return playerStatus.getBuffs().split(" ");
	}

}
