package zdm.fate.web.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import zdm.fate.common.config.IllegalDataIntegrityException;
import zdm.fate.common.constant.WebConstant;
import zdm.fate.domain.entity.SysUser;
import zdm.fate.domain.repository.SysUserRepository;
import zdm.fate.service.PlayerStatusService;

@Controller
public class HelloController {

	private static final Integer PLAYERID = 1;

	@Autowired
	private SysUserRepository userRepository;
	@Autowired
	private PlayerStatusService playerStatusService;

	@RequestMapping("/Hello")
	public String hello(
			@RequestParam(value = "name", required = false, defaultValue = "World!!") String name,
			Model model) {
		model.addAttribute("name", name);
		return "hello";
	}

	@RequestMapping(value = {"/index", "/"})
	public String index(HttpServletRequest request, Model model) {
		Principal principal = request.getUserPrincipal();
		if (principal == null) return "index";
		String name = principal.getName();
		SysUser user = userRepository.findByUsername(name);
		try {
			int[] hpBar = playerStatusService.hpBar(user);
			List<String> hpBarStr = new ArrayList<String>();
			int i;
			for (i = 0; i < hpBar[0]; i++)
				hpBarStr.add(WebConstant.HP_RED);
			for (i = 0; i < hpBar[1]; i++)
				hpBarStr.add(WebConstant.HP_BLANK);
			for (i = 0; i < hpBar[2]; i++)
				hpBarStr.add(WebConstant.HP_BLUE);
			for (i = 0; i < hpBar[3]; i++)
				hpBarStr.add(WebConstant.HP_RED);
			for (i = 0; i < hpBar[4]; i++)
				hpBarStr.add(WebConstant.HP_BLANK);
			for (i = 0; i < hpBar[5]; i++)
				hpBarStr.add(WebConstant.HP_BLUE);
			model.addAttribute("hpBarStr", hpBarStr);

			model.addAttribute("buffs", playerStatusService.findBuffs(user));
		} catch (IllegalDataIntegrityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/loginSubmit", method = RequestMethod.POST)
	public String login() {
		return "hello";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterPage(Model model) {
		SysUser user = new SysUser();
		model.addAttribute("user", user);
		return "register";
	}

	@RequestMapping(value = "/registerSubmit", method = RequestMethod.POST)
	public String register(SysUser user) {
		userRepository.save(user);
		playerStatusService.createStatus(user);
		return "redirect:/index?register";
	}

	@RequestMapping("/HelloPlayer")
	public String helloPlayer(Model model) {
		SysUser player = userRepository.findOne(PLAYERID);
		model.addAttribute("name", player.getUsername());
		return "hello";
	}
}