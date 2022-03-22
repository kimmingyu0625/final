package net.edupoll.kr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import net.edupoll.kr.service.TimeService;

@Controller
public class TimeCountController {

	@Autowired
	TimeService timeService;
	
	
	@ResponseBody
	@RequestMapping("/message/data")
	public List<Object[]> timecount() {
		
		List<Object[]> ret = timeService.timeCount();
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(ret));
	
		return ret;
	}


	@RequestMapping("/messages")
	public String massageHandle() {
		
	
		
		return "statistics/message";
	}
}
