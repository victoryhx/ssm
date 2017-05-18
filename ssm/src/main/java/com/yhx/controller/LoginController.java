package com.yhx.controller;

import javax.servlet.http.HttpSession;

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

	// ��¼
	@RequestMapping(value = "/login")
	public String login(HttpSession session, String username, String password)
			throws Exception {
		// ����service�����û������֤
		//���û���ȥ��ѯ�����û���Ϣ
		Login data = loginservice.getLogin(username);
		if (data != null) {
			//�ж��û������Ƿ���ͬ
			if (password.equals(data.getPassword())) {
				// ��session�б����û������Ϣ
				session.setAttribute("username", username);
			}
		}
		return "redirect:/Index/index.action";

	}

	// �˳�
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		// ���session
		session.invalidate();

		// �ض�����ҳ��
		return "redirect:/Index/index.action";
	}
}
