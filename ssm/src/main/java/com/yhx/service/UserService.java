package com.yhx.service;

import java.util.List;
import java.util.Map;

import com.yhx.po.User;

import cn.yhx.exception.UserException;

public interface UserService {
	public User getUser(int id) throws UserException;
	
	public void insert(Map<String, String> map) throws UserException;

	public void delete(int id) throws UserException;

	public void update(Map<String, String> map) throws UserException;
	
	
	
	
	
	//测试方法1
	public List<User> findUser(String name) throws UserException;
	//测试方法2
	public List<User> findAllUser() throws UserException;
	//测试方法3
	public List<User> getUserMap(String name) throws UserException;
	//测试方法4
	public List<User> getUserHasMap(Map<String, String> map) throws UserException;
}
