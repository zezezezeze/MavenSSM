package com.millery.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.millery.domain.TbUser;
import com.millery.services.AbstractAction;
import com.millery.services.UserDaoService;
import com.millery.util.md5.Md5Util;

/**
 * @author Jack
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractAction {
	@Autowired
	UserDaoService userDaoService = null;

	@RequestMapping("/index")
	public String main() {
		return "/user/index";
	}

	@RequestMapping("/addphoto")
	public String main1() {
		return "/user/addPhoto";
	}

	/**
	 * 上传图片
	 * 
	 * @param photoFile
	 * @return
	 */
	@RequestMapping("/add")
	public String Add(MultipartFile photoFile, HttpServletRequest request) {
		// 图片不为空时进行保存
		if (!photoFile.isEmpty()) {
			String flieName = super.creratFileName(photoFile);
			super.saveFile(photoFile, flieName, request);
		}
		return "/user/index";
	}

	@Override
	public String getFileUploadDir() {
		// TODO Auto-generated method stub
		return "/uplode/emp";
	}

	/**
	 * 以下两个方法执行添加新用户操作
	 * 
	 * @return 添加结果
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String AddUserGet() {
		return "/user/addUser";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String AddUser(TbUser user) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/user/addUser.do";
	}

	@RequestMapping("/success")
	public String success() {
		return "/user/success";
	}
	@RequestMapping(value="/pwdUpdate",method=RequestMethod.POST)
	public String pwdUptate(){
		
		return "";
	}
	
}
