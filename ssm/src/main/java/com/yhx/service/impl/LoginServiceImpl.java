package com.yhx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhx.mapper.LoginMapper;
import com.yhx.po.Login;
import com.yhx.service.LoginService;

import cn.yhx.exception.UserException;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	public LoginMapper loginMapper;
	
	public Login getLogin(String username) throws UserException{ 
		// TODO Auto-generated method stub
      
		Login login = loginMapper.getLogin(username);
		return login;
	}

}
