package zdm.fate.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zdm.fate.common.util.SecurityUtil;
import zdm.fate.domain.entity.SysUser;
import zdm.fate.domain.repository.PlayerStatusRepository;
import zdm.fate.domain.repository.SysUserRepository;
import zdm.fate.service.TileService;

@Controller
@RequestMapping("/map")
public class MapController {

	@Autowired
	private SysUserRepository userRepository;
	@Autowired
	private PlayerStatusRepository playerStatusRepository;
	@Autowired
	private TileService tileService;

	@RequestMapping(value = {"", "/"})
	public String map(Model model, HttpServletRequest request) {
		SysUser sysUser = SecurityUtil.getUser(request, userRepository);
		model.addAttribute("sight",
				playerStatusRepository.findOne(sysUser.getId()).getSight());
		model.addAttribute("userTile",
				playerStatusRepository.findOne(sysUser.getId()).getTile());

		model.addAttribute("map", tileService.getMap(sysUser));
		return "addons/map";
	}
}
