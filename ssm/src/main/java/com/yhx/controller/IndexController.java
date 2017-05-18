package com.yhx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yhx.po.User;
import com.yhx.service.UserService;

@Controller
@RequestMapping("/Index")
public class IndexController {

	@Autowired
	public UserService userService;

	// Ö÷Ò³Ãæ
	@RequestMapping("/index")
	public String index(String textInput,HttpSession session, HttpServletRequest request, HttpServletResponse response,Model model)
			throws Exception {
		String pageNum = request.getParameter("pageNum");
		String pageSize = request.getParameter("pageSize");
		List<User> user=null;
		int num = 1;
		int size = 5;
		if (pageNum != null && !"".equals(pageNum)) {//
			num = Integer.parseInt(pageNum);
		}
		if (pageSize != null && !"".equals(pageSize)) {
			size = Integer.parseInt(pageSize);
		}
		PageHelper.startPage(num, size);
        if(textInput!=null)
        {
        	user = userService.findUser(textInput);
        }else
        {
        	user = userService.findAllUser();
        }		
		PageInfo<User> page = new PageInfo<User>(user);
		model.addAttribute("pagehelper", page);
		return "index";
	}	
}