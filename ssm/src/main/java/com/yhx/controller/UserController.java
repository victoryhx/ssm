package com.yhx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhx.po.User;
import com.yhx.service.UserService;

import cn.yhx.exception.UserException;

@Controller
@RequestMapping("/User")
public class UserController {

	@Autowired
	public UserService userService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() throws Exception {
		return "user/Add";
	}

	@RequestMapping("/addInfo")
	public String addInfo(HttpServletRequest request) throws Exception {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("age", age);
		userService.insert(map);
		return "redirect:/Index/index.action";
	}

	@RequestMapping("/edit")
	public String edit(String id, Model model) throws Exception {
		User user = userService.getUser(Integer.parseInt(id));
		if (user == null) {
			throw new UserException("用户信息不存在!");
		}
		model.addAttribute("edit", user);
		return "user/edit";
	}

	@RequestMapping("/editInfo")
	public String editInfo(String name, String age, HttpSession session) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("age", age);
		userService.update(map);
		return "redirect:/Index/index.action";
	}

	@RequestMapping("/delete")
	public String delete(String id, HttpSession session) throws Exception {
		userService.delete(Integer.parseInt(id));
		return "redirect:/Index/index.action";
	}

	/***
	 * springmvc 注解开发json数据返回
	 * 
	 * @return
	 * @throws UserException 
	 */
	@ResponseBody
	@RequestMapping("requestJson")
	public List<User> requestJson() throws UserException {
		 List<User> userlist=	userService.findUser("Tom");
		return userlist;
	}
	
}
