package com.millery.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

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
	
	//������֤��
	@RequestMapping("/createImg")
	public void createImg(HttpServletRequest request,HttpServletResponse response){
		//������֤�뼰ͼƬ
		Object[] objs = ImageUtil.createImage();
		//����֤�����session
		HttpSession sn = request.getSession();
		sn.setAttribute("imgCode", objs[0]);
		//��ԭͼƬ����ָ����ѹ���㷨����ѹ������ͼƬ����������
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
			//��֤�����
			 throw new UserException("��֤���������������");	
		}
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
				userName, Md5Util.md5(password));
		try {
			session.setAttribute("userName",userName);
			subject.login(usernamePasswordToken);
			return "redirect:/user/success.do";
		} catch (Exception e) {
			// model.addAttribute("msg", "�û��������������,��½ʧ��");
			e.printStackTrace();
			 throw new UserException("�ʺŻ��������");	
		}
	}
}
