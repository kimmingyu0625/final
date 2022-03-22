package net.edupoll.kr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.edupoll.kr.entity.AccountVo;
import net.edupoll.kr.entity.MessageVo;
import net.edupoll.kr.service.MessageService;
import net.edupoll.kr.websocket.AlertService;

@Controller
public class MessageController {

	@Autowired
	MessageService  messageService;
	
	@Autowired
	AlertService alertService;
	
	@RequestMapping(path ="/message")
	public String messageview(@ModelAttribute MessageVo vo, Model model,HttpSession session) {
			
			AccountVo id = new AccountVo();
		
			id = (AccountVo)session.getAttribute("loginUser");
			
			vo.setRecipient(id.getUserId());
			
			
		
			model.addAttribute("list", messageService.selectByRecipient(vo.getRecipient()));
			
			
			model.addAttribute("count", messageService.selectCount(id.getUserId()));
				
		
			
		return "message/received";
		
	}
	
	
	@RequestMapping(path ="/message/sent")
	public String messagesent(@ModelAttribute MessageVo vo,Model model,HttpSession session) {
		
		
		AccountVo id = new AccountVo();
		
		id = (AccountVo)session.getAttribute("loginUser");
		
		vo.setWriter(id.getUserId());
		
		model.addAttribute("list",messageService.selectByWriter(vo.getWriter()));
	
		
		
		 return "message/sent";
		
		
	}
	
	
	@RequestMapping(path ="/message/write", method = RequestMethod.GET)
	public String messagewrite(HttpSession session,@ModelAttribute MessageVo vo ,Model model) {
		
	
		
		
		return "message/write";
		
	}
	@RequestMapping(path ="/message/rewrite", method = RequestMethod.GET)
	public String messagerewrite(HttpSession session,@ModelAttribute MessageVo vo , @RequestParam("writer") String param,Model model) {
		
		AccountVo id = new AccountVo();
		id = (AccountVo)session.getAttribute("loginUser");
		
		
		System.out.println(param);
		model.addAttribute("list",param);
		vo.setWriter(id.getUserId());
		vo.setRecipient(param);
		
		
		return "message/rewrite";
		
	}
	
	
	@RequestMapping(path = "/message/detail")
	public String messagedetail(@ModelAttribute MessageVo vo,@RequestParam String writer,Model model,HttpSession session) {
			AccountVo avo = new AccountVo();
			
			avo = (AccountVo)session.getAttribute("loginUser");
			
			System.out.println(vo.getNo());
			System.out.println(avo.getUserId());
			System.out.println(writer);
			
			model.addAttribute("list", messageService.selectById(vo.getNo()));
			
			if(avo.getUserId().equals( writer)) {
			messageService.sentdataUpdate(vo.getNo());
			}
		return "message/detail";
	}
	
	
	@RequestMapping(path = "/message/insert", method = RequestMethod.POST)
	public String messageinsert(@ModelAttribute MessageVo vo,HttpSession session) {
			AccountVo id = new AccountVo();
			
			 id = (AccountVo)session.getAttribute("loginUser");
			 
			 vo.setWriter(id.getUserId());
			 
			boolean r = messageService.insertSend(vo);
		
				if(r) {alertService.alertNewMessage(vo.getRecipient());
				}
		return "/message/received";
	}
	
	@ResponseBody
	@RequestMapping(path ="/message/delete",method = RequestMethod.POST)
	public String messagedelete(@RequestParam(value = "checkarr[]") List<String> ch) {
			
		System.out.println(ch);
		
			messageService.checkDelete(ch);
			
		
		
		return "redirect:/";
	}
	
}

