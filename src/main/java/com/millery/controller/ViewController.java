package com.millery.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.servlet.ModelAndView;

import com.millery.domain.TbGroup;
import com.millery.domain.TbRole;
import com.millery.domain.TbUser;
import com.millery.services.UserDaoService;
import com.millery.util.file.ImageUtil;
import com.millery.util.file.UserException;
import com.millery.util.md5.Md5Util;

/**
 * @author Jack
 *
 */
@Controller
@RequestMapping("/view")
public class ViewController {
	@Autowired
	UserDaoService userDaoService = null;

	@RequestMapping("/login")
	public String view() {
		return "/view/login";
	}
	@RequestMapping("/viewMain")
	public String viewmain() {
		return "/view/viewMain";
	}
	@RequestMapping("/viewAbout")
	public String viewAbout() {
		return "/view/viewAbout";
	}
	@RequestMapping("/viewSidebar")
	public String viewSidebar() {
		return "/view/viewSidebar";
	}
	@RequestMapping("/viewContact")
	public ModelAndView viewContact(HttpServletRequest req) {
		HttpSession session = req.getSession();
		ModelAndView modelAndView=new ModelAndView();
		String name = (String) session.getAttribute("userName");
		if (name != null &&name != "") {
			TbUser user = userDaoService.queryTbUserByUsername(name);
			TbGroup group = userDaoService.queryTbGroupByid(user.getGroupId());
			TbRole role = userDaoService.queryTbRoleByid(user.getGroupId());
			modelAndView.setViewName("/view/viewContact");
			modelAndView.addObject("user", user);
			modelAndView.addObject("group", group);
			modelAndView.addObject("role", role);
			
		}else{
			modelAndView.setViewName("/view/login");
		}
		return modelAndView;
	}
	
	//生成验证码
	@RequestMapping("/createImg")
	public void createImg(HttpServletRequest request,HttpServletResponse response){
		//创建验证码及图片
		Object[] objs = ImageUtil.createImage();
		//将验证码存入session
		HttpSession sn = request.getSession();
		sn.setAttribute("imgCode", objs[0]);
		//将原图片按照指定的压缩算法进行压缩，将图片输出给浏览器
		response.setContentType("image/png");
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			ImageIO.write((BufferedImage) objs[1], "png", os);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@RequestMapping("/error")
	public String error() {
		return "/view/error";
	}

	@RequestMapping(value = "/loginyz", method = RequestMethod.POST)
	@RequiresGuest
	public String login(HttpServletRequest req) {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String yzm = req.getParameter("yzm");
		HttpSession session = req.getSession();
		String imgCode = (String) session.getAttribute("imgCode");
		if(!yzm.equals(imgCode)){
			//验证码错误
			 throw new UserException("验证码错误，请重新输入");	
		}
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
				userName, Md5Util.md5(password));
		try {
			session.setAttribute("userName",userName);
			subject.login(usernamePasswordToken);
			return "redirect:/view/viewMain.do";
		} catch (Exception e) {
			// model.addAttribute("msg", "用户名或者密码错误,登陆失败");
			e.printStackTrace();
			 throw new UserException("帐号或密码错误");	
		}
	}


    @RequestMapping(value = "tuichu", method = RequestMethod.GET)
    public String tuichu(HttpServletRequest request, HttpServletResponse response)   {
    	try {
    		 HttpSession session = request.getSession(false);//防止创建Session  
    	      
    	          
    	        session.removeAttribute("userName");  
		} catch (Exception e) {
			// TODO: handle exception
		}
     
        return "redirect:/view/viewMain.do";
    }
}
