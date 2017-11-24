package com.millery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;







import com.millery.domain.User;
import com.millery.services.AbstractAction;
import com.millery.services.UserDaoService;


/**
 * @author Jack
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractAction{ 
	@Autowired
    UserDaoService userDaoService=null;
	@RequestMapping("/index")
	public String main() {
		return "/user/index";
	}
	
	 @RequestMapping("/login1")
	    public String view() {
	        return "login";
	}
	 @RequestMapping("/addphoto")
		public String main1() {
			return "/user/addPhoto";
		}
	 /**
	 * @param photoFile
	 * @return
	 */
	@RequestMapping("/add")
	 public String Add(MultipartFile photoFile,HttpServletRequest request){
		// 图片不为空时进行保存 
		if (!photoFile.isEmpty()) {
			 String flieName = super.creratFileName(photoFile);
			 super.saveFile(photoFile, flieName, request);
		 }
		return "/user/index";
	 }
	@RequestMapping("/addUser")
	 public String AddUser(User user){
		if(user.getU_Id()!=null){
			userDaoService.insertUser(user);
		}
		return null;
	 }
	
	
	 /**
	 * 用户登录方法
	 * @param model 实体类
	 * @param session
	 * @return User
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	    public ModelAndView login(User model, HttpSession session) {
	        User user = userDaoService.getUser(model.getU_phone());

	        if (user == null || !user.getU_password().equals(model.getU_password())) {
	            return new ModelAndView("redirect:/user/user/login.do");
	        } else {
	            session.setAttribute("user", user);
	            ModelAndView mav = new ModelAndView();
	            mav.setViewName("redirect:/user/user/index.do");
	            return mav;
	        }
	    }
	@Override
	public String getFileUploadDir() {
		// TODO Auto-generated method stub
		return "/uplode/emp";
	}

	    @RequestMapping("/successUrl")
	    public String  name2() {
			return "/user/success";
		}
	    @RequestMapping(value="/loginyz", method = RequestMethod.POST)
	    @RequiresGuest
	    public String login(User user,Model model){
	        Subject subject = SecurityUtils.getSubject();
	        UsernamePasswordToken usernamePasswordToken = new  UsernamePasswordToken(user.getU_phone(),user.getU_password());
	        try {
	            subject.login(usernamePasswordToken);
	            return "redirect:/user/success.do";
	        } catch (Exception e) {
	            //model.addAttribute("msg", "用户名或者密码错误,登陆失败");
	            e.printStackTrace();
	            return "redirect:/user/index.do";
	        }
	    }
}
