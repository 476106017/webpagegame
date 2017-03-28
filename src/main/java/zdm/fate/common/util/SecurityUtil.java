package zdm.fate.common.util;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import zdm.fate.domain.entity.SysUser;
import zdm.fate.domain.repository.SysUserRepository;

public class SecurityUtil {

	public static SysUser getUser(HttpServletRequest request, SysUserRepository userRepository) {
		Principal principal = request.getUserPrincipal();
		return userRepository.findByUsername(principal.getName());
	}
}
