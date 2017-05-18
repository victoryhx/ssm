package com.yhx.mapper;

import java.util.List;
import java.util.Map;

import com.yhx.po.User;

import cn.yhx.exception.UserException;

public interface UserMapper {
	public User getUser(int id) throws UserException;

	public void insert(Map<String, String> map)throws UserException;

	public void delete(int id)throws UserException;

	public void update(Map<String, String> map)throws UserException;

	
	
	//���Է���1
	public List<User> findUser(String name) throws UserException;
	//���Է���2
	public List<User> findAllUser() throws UserException;
	//���Է���3
	public List<User> getUserMap(String name) throws UserException;
	//���Է���4
	public List<User> getUserHasMap(Map<String, String> map) throws UserException;
}
