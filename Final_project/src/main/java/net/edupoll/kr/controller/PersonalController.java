package net.edupoll.kr.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.edupoll.kr.entity.AccountVo;
import net.edupoll.kr.service.LoginService;
import net.edupoll.kr.service.MailService;

@Controller
public class PersonalController {

		@Autowired
		LoginService loginService;
	
		
		@Autowired
		MailService mailService;
	
		@RequestMapping("/settings")
		public String settingHandle() {
			
			return "personal/settings";
		}
		
		
		@RequestMapping("/settings/modify")
		public String settingsEmailHandle(@RequestParam String address ,@RequestParam String zipcode, @RequestParam String email,HttpSession session) {
					
			AccountVo vo = (AccountVo)session.getAttribute("loginUser");
			
			vo.setAddress(address);
			vo.setEmail(email);
			vo.setZipcode(zipcode);
			
			loginService.updateAccountById(vo);
			return "personal/settings";
			
			
		}
		
		@GetMapping("/settings/auth")
		public String settingsAuthHandle() {
			
			
			return "personal/auth";
		}
		
		@ResponseBody
		@RequestMapping("/settings/reqAuth")
		public String reqAuthHandle(HttpSession session , Model model) throws InterruptedException {
			//메일서비스를 이용하게 될꺼임
			
			AccountVo id = (AccountVo)session.getAttribute("loginUser");
			
			
			String email = loginService.selectEmail(id.getUserId());
			
			
			UUID uuid = UUID.randomUUID();
			String temp = uuid.toString();
			temp = temp.substring(0,4);
			
			mailService.sendTestHTMLMail(email,temp);
			
			
			System.out.println("reqAuthHandle");
			Thread.sleep(5000);
			
			session.setAttribute("temp",temp);
			
			
			return temp;
		}
		
		@RequestMapping("/settings/verify")
		public String verifyHandle(HttpSession session,@RequestParam String authKey) {
			AccountVo id = (AccountVo)session.getAttribute("loginUser");
			String key = (String)session.getAttribute("temp");
			System.out.println(key);
			System.out.println(authKey);
			System.out.println(id.getUserId());
			if(key.equals(authKey)) {
				
				System.out.println(key);
				System.out.println(authKey);
				
				loginService.updateauth(id.getUserId());
				return "redirect:/settings";
			}
			
			
			
		
			return "/";
		}
		
		@RequestMapping(path = "/settings/profile", method = RequestMethod.POST)
		public String settingimage(@RequestParam MultipartFile customfile) throws IllegalStateException, IOException {
			
		String originalfile = customfile.getOriginalFilename();
		String extension = originalfile.substring(originalfile.lastIndexOf("."));
		
		String storagefilename = UUID.randomUUID().toString().replaceAll("-","")+extension;
		
			File file = new File(storagefilename);
			
			customfile.transferTo(file);
			
			
			
			
			
			
			return "settings";
			
		}
		
}
