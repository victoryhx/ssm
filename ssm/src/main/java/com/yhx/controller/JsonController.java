package com.yhx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhx.po.User;
import com.yhx.service.UserService;

import cn.yhx.exception.UserException;

@Controller
@RequestMapping("/Json")
public class JsonController {

	@Autowired
	public UserService userService;

	// 请求json串，输出json串
	// @RequestBody将请求信息json串转成User对象
	// @ResponseBody将User转成json输出
	@ResponseBody
	@RequestMapping("/requestJson")
	public User requestJson(@RequestBody User user) throws UserException {
		return user;
	}

	@ResponseBody
	@RequestMapping("/responseJson")
	public List<User> responseJson(String name) throws UserException {
		List<User> userlist = userService.findUser(name);
		return userlist;
	}

	@ResponseBody
	@RequestMapping("/restfull/{name}")
	public List<User> restfull(@PathVariable("name") String name) throws UserException {
		List<User> userlist = userService.findUser(name);
		return userlist;
	}
	@RequestMapping(value = "/jsonIndex", method = RequestMethod.GET)
	public String index() throws Exception {
		return "jsonTest";
	}
}
