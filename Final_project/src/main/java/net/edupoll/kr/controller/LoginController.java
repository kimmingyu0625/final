package net.edupoll.kr.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.edupoll.kr.entity.AccountVo;
import net.edupoll.kr.service.LoginService;

@Controller

public class LoginController {

	@Autowired
	LoginService loginService;
	
		@RequestMapping("/login")
		public String loginHandle() {
			
			return "login/login";
		}
	
	
		@RequestMapping(path="/session", method = RequestMethod.POST)
		public String loginHandle(HttpSession session,@RequestParam String loginId, @RequestParam String loginPass,Model model) {
			
			
			boolean valid = loginService.selectOne(loginId,loginPass);
			
			if(valid) {
				AccountVo vo = loginService.findAccountById(loginId);
			
				session.setAttribute("loginUser",vo);
			
				return "redirect:/settings";
			}else {
				model.addAttribute("err","error");
				return "login/login";
				
			}
			
			
		}
	
		
}
