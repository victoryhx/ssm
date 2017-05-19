package com.yhx.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yhx.po.Login;
import com.yhx.service.LoginService;


@Controller
@RequestMapping("/Login")
public class LoginController {

	@Autowired
	public LoginService loginservice;
	private  Logger logger = LoggerFactory.getLogger(LoginController.class);
	// 登录
	@RequestMapping(value = "/login")
	public String login(HttpSession session, String username, String password)
			throws Exception {

		// 调用service进行用户身份验证
		//用用户名去查询有无用户信息
		Login data = loginservice.getLogin(username);
		if (data != null) {
			//判断用户密码是否相同
			if (password.equals(data.getPassword())) {
				// 在session中保存用户身份信息
				session.setAttribute("username", username);
				logger.error("登录成功");
				logger.info("info");
				logger.debug("debug");
			}
		}
		return "redirect:/Index/index.action";

	}

	// 退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		// 清除session
		session.invalidate();

		// 重定向到主页面
		return "redirect:/Index/index.action";
	}
}
