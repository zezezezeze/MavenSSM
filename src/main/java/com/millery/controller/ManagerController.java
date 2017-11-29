package com.millery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	@RequestMapping("/managerLayout")
	public String managerLayout(){
		
		return "/manager/managerLayout";
	}
	
	@RequestMapping("/main")
	public String main(){
		
		return "/manager/main";
	}
}
