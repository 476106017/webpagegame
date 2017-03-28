package zdm.fate.service;

import zdm.fate.common.config.IllegalDataIntegrityException;
import zdm.fate.common.constant.Buff;
import zdm.fate.domain.entity.SysUser;

public interface PlayerStatusService {
	/**
	 * {red1,blank1,blue1,red2,blank2,blue2}
	 * 
	 * @throws IllegalDataIntegrityException
	 */
	public int[] hpBar(SysUser user) throws IllegalDataIntegrityException;

	public void createStatus(SysUser user);

	public String[] findBuffs(SysUser user);

	public String addBuffs(SysUser user, Buff[] buffs);

	public String removeBuffs(SysUser user, Buff[] buffs);
}
