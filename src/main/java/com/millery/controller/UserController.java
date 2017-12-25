package com.millery.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.millery.domain.TbUser;
import com.millery.services.AbstractAction;
import com.millery.services.UserDaoService;
import com.millery.util.file.UserException;
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
	 * �ϴ�ͼƬ
	 * 
	 * @param photoFile
	 * @return
	 */
	@RequestMapping("/add")
	public String Add(MultipartFile photoFile, HttpServletRequest request,Long id) {
		// ͼƬ��Ϊ��ʱ���б���
		if (!photoFile.isEmpty()) {
			String flieName = super.creratFileName(photoFile);
			String fileString = super.saveFile(photoFile, flieName, request);
			if(!"false".equals(fileString)){
				userDaoService.updateUserImage(fileString.substring(81), id);
			}
		}
		return "redirect:/view/viewContact.do";
	}

	@Override
	public String getFileUploadDir() {
		// TODO Auto-generated method stub
		return "/uplode/emp";
	}

	/**
	 * ������������ִ��������û�����
	 * 
	 * @return ��ӽ��
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
			// Ĭ�����붼��123456
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
	@RequestMapping(value="/updatePwd",method=RequestMethod.POST)
	public @ResponseBody String updatePwd(long id, String pwd){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", Md5Util.md5(pwd));
		try {
			 userDaoService.updatePwd(map);
			 return "true";
		} catch (Exception e) {
			// TODO: handle exception
			 throw new UserException("�����޸�ʧ�ܣ��뻻���������²����ޣ�");	
		}
	}
	
	
}
