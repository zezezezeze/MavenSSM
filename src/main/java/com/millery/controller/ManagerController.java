package com.millery.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.millery.domain.TbGroup;
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
	public String managerLayout() {

		return "/manager/managerLayout";
	}

	@RequestMapping("/main")
	public String main() {

		return "/manager/main";
	}
	@RequestMapping("/login")
	public String login() {

		return "/manager/login";
	}

	@RequestMapping("/userList")
	public ModelAndView userList(
			@RequestParam(value = "cp", defaultValue = "1") int currentPage,
			@RequestParam(value = "ls", defaultValue = "5") int lineSize,
			@RequestParam(value = "col", defaultValue = "roleId") String column,
			@RequestParam(value = "kw", defaultValue = "") String keyWord) {

		List<TbUser> tbUsers = userDaoService.queryTbUserList(column, keyWord,
				currentPage, lineSize);
		List<TbUser> tbUserCount = userDaoService.queryTbUserCount(column,
				keyWord);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/userList");
		mav.addObject("userList", tbUsers);
		int num = (tbUserCount.size()) % lineSize;
		if (num == 0) {
			mav.addObject("userCount", (tbUserCount.size()) / lineSize);
		} else {
			mav.addObject("userCount", ((tbUserCount.size()) / lineSize) + 1);
		}

		return mav;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView addUser() {
		List<TbGroup> tbGroup = userDaoService.queryTbGruopList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/addUser");
		mav.addObject("tbGroupList", tbGroup);
		return mav;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public @ResponseBody String userMessage(String userName, String realName,
			Integer userType) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = formatter.format(date);
		long id = Long.parseLong(time);
		TbUser user = new TbUser();
		try {
			// 默认密码都是123456
			user.setId(id);
			String pwMd5 = Md5Util.md5("123456");
			user.setPassword(pwMd5);
			user.setRoleId(userType);
			user.setRealName(realName);
			user.setUserName(userName);
			userDaoService.insertTbUser(user);
			return "true";
		} catch (Exception e) {
			throw new UserException("用户添加失败！请换个姿势重新操作噢！");
		}
	}

	@RequestMapping("/urlList")
	public ModelAndView urlList() {
		List<TbMoudle> tbMoudle = userDaoService.queryTbMoudleList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/url");
		mav.addObject("urlList", tbMoudle);
		return mav;
	}

	@RequestMapping(value = "/updateUrlName", method = RequestMethod.POST)
	public @ResponseBody String updateUrlName(int id, String name) {

		try {
			userDaoService.updateUrlName(id, name);
			return "true";
		} catch (Exception e) {
			throw new UserException("名称修改失败！！请换个姿势重新操作噢！");
		}
	}

	@RequestMapping("/deleteUser")
	public @ResponseBody String deleteUser(long id) {
		try {
			userDaoService.deleteTbUser(id);
			return "true";
		} catch (Exception e) {
			throw new UserException("用户删除失败！！请换个姿势重新操作噢！");
		}
	}

	@RequestMapping("/deleteClass")
	public @ResponseBody String deleteClass(Integer id) {
		try {
			if(id.equals(3)){
				throw new UserException("该项谁都不可以删除");
			}else{
			userDaoService.deleteTbGroup(id);
			}
			return "true";
		} catch (Exception e) {
			throw new UserException("班级删除失败！！请换个姿势重新操作噢！");
		}
	}

	@RequestMapping("/classList")
	public ModelAndView classList(
			@RequestParam(value = "cp", defaultValue = "1") int currentPage,
			@RequestParam(value = "ls", defaultValue = "5") int lineSize) {

		List<TbGroup> tbGroup = userDaoService.queryTbGroupList(currentPage,
				lineSize);
		List<TbGroup> tbGroupCount = userDaoService.queryTbGruopList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/classList");
		mav.addObject("classList", tbGroup);
		int num = (tbGroupCount.size()) % lineSize;
		if (num == 0) {
			mav.addObject("classCount", (tbGroupCount.size()) / lineSize);
		} else {
			mav.addObject("classCount", ((tbGroupCount.size()) / lineSize) + 1);
		}

		return mav;
	}
	
	@RequestMapping(value = "/addClass", method = RequestMethod.GET)
	public ModelAndView addClass() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/manager/addClass");
		return mav;
	}

	@RequestMapping(value = "/addClass", method = RequestMethod.POST)
	public @ResponseBody String addClass(String classYear, Integer classNum,
			String classType) {
		TbGroup tbGroup = new TbGroup();
		try {
			tbGroup.setClassNum(classNum);
			tbGroup.setClassType(classType);
			tbGroup.setClassYear(classYear);
			userDaoService.insertTbGroup(tbGroup);
			return "true";
		} catch (Exception e) {
			throw new UserException("用户添加失败！请换个姿势重新操作噢！");
		}
	}
	
	@RequestMapping(value = "/loginyz", method = RequestMethod.POST)
	@RequiresGuest
	public String login(HttpServletRequest req) {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
				userName, Md5Util.md5(password));
		try {
			session.setAttribute("userName",userName);
			subject.login(usernamePasswordToken);
			return "redirect:/manager/main.do";
		} catch (Exception e) {
			// model.addAttribute("msg", "用户名或者密码错误,登陆失败");
			e.printStackTrace();
			 throw new UserException("帐号或密码错误");	
		}
	}
	@RequestMapping(value = "managertuichu", method = RequestMethod.GET)
    public String tuichu(HttpServletRequest request, HttpServletResponse response)   {
    	try {
    		 HttpSession session = request.getSession(false);//防止创建Session  
    	      
    	        session.removeAttribute("userName");  
		} catch (Exception e) {
			// TODO: handle exception
		}
     
        return "redirect:/manager/login.do";
    }
}
