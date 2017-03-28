package zdm.fate.service;

import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import zdm.fate.domain.entity.SysUser;
import zdm.fate.domain.repository.SysUserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {
	@Autowired
	private SysUserRepository sysUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = sysUserRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("no user found");
		} else {
			Set<GrantedAuthority> roles = createAuthoritySet(sysUserRepository.findOne(user.getId()));
			return new User(user.getUsername(), user.getPassword(), roles);
		}
	}

	private Set<GrantedAuthority> createAuthoritySet(SysUser user) {
		return Collections.singleton((GrantedAuthority) new SimpleGrantedAuthority(user.getRole()));
	}

}