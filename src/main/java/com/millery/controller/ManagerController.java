package com.millery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.millery.domain.TbUser;
import com.millery.services.UserDaoService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	UserDaoService userDaoService = null;
	
	
	@RequestMapping("/managerLayout")
	public String managerLayout(){
		
		return "/manager/managerLayout";
	}
	
	@RequestMapping("/main")
	public String main(){
		
		return "/manager/main";
	}
	

	@RequestMapping("/userList")
	public ModelAndView userList(@RequestParam(value = "cp", defaultValue = "1") int currentPage,
			@RequestParam(value = "ls", defaultValue = "5") int lineSize,
			@RequestParam(value = "col", defaultValue = "roleId") String column,
			@RequestParam(value = "kw", defaultValue = "") String keyWord){
		
		List<TbUser> tbUsers=userDaoService.queryTbUserList(column, keyWord, currentPage, lineSize);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/userList");
		mav.addObject("userList",tbUsers);
		return mav;
	}
	
	@RequestMapping(value="/userMessage",method = RequestMethod.GET)
	public ModelAndView userMessage(String name){
		
		TbUser tbUser = userDaoService.queryTbUserByUsername(name);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/userMessage");
		mav.addObject("userMessage",tbUser);
		return mav;
	}
	
}
