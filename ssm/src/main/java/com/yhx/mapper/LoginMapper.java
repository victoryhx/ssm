package com.yhx.mapper;

import com.yhx.po.Login;

import cn.yhx.exception.UserException;

public interface LoginMapper {
	public Login  getLogin(String username) throws UserException;
}
