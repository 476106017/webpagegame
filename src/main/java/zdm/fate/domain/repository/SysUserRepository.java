package zdm.fate.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import zdm.fate.domain.entity.SysUser;

@Transactional
public interface SysUserRepository extends JpaRepository<SysUser, Integer> {

	SysUser findByUsername(String username);

}
