package com.millery.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.millery.domain.TbMoudle;
import com.millery.domain.TbUser;
import com.millery.services.UserDaoService;
import com.millery.util.file.UserException;
import com.millery.util.md5.Md5Util;

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
	@RequestMapping(value="/addUser",method = RequestMethod.GET)
	public ModelAndView addUser(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/addUser");
		return mav;
	}
	@RequestMapping(value="/addUser",method = RequestMethod.POST)
	public String userMessage(TbUser user){
		try{
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String time = formatter.format(date);
			long id = Long.parseLong(time);
			// 默认密码都是123456
			user.setId(id);
			String pwMd5 = Md5Util.md5("123456");
			user.setPassword(pwMd5);
			user.setRoleId(2);
			userDaoService.insertTbUser(user);
			return "redirect:/manager/userList.do";
		} catch (Exception e) {
			 throw new UserException("用户添加失败！请换个姿势重新操作噢！");	
		}
	}
	
	@RequestMapping("/urlList")
	public ModelAndView urlList(){
		List<TbMoudle> tbMoudle = userDaoService.queryTbMoudleList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/url");
		mav.addObject("userList",tbMoudle);
		return mav;
	}
	
	@RequestMapping(value="/updateUrlName",method = RequestMethod.POST)
	public boolean updateUrlName(int id, String name){
		boolean flag = false;
		try{
			flag = userDaoService.updateUrlName(id, name);
			return flag;
		} catch (Exception e) {
			 throw new UserException("名称修改失败！！请换个姿势重新操作噢！");	
		}
	}
	
	@RequestMapping("/deleteUser")
	public boolean deleteUser(long id){
		boolean flag = false;
		try {
			flag = userDaoService.deleteTbUser(id);
			return flag;
		} catch (Exception e) {
			throw new UserException("用户删除失败！！请换个姿势重新操作噢！");	
		}
	}
}
