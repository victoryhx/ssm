package com.yhx.service;

import com.yhx.po.Login;

import cn.yhx.exception.UserException;

public interface LoginService {
	public Login  getLogin(String username) throws UserException;
}
