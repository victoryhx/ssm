package com.yhx.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yhx.mapper.UserMapper;
import com.yhx.po.User;
import com.yhx.service.UserService;

import cn.yhx.exception.UserException;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService  {

	@Autowired
	public UserMapper userMapper;
	
	public User getUser(int id) throws UserException {
		User user=userMapper.getUser(id);
		return user;
	}
	public void delete(int id) throws UserException {
		// TODO Auto-generated method stub
		userMapper.delete(id);
	}
	public void insert(Map<String, String> map) throws UserException {
		// TODO Auto-generated method stub
		userMapper.insert(map);
	}
	public void update(Map<String, String> map) throws UserException {
		// TODO Auto-generated method stub
		userMapper.update(map);
	}
	
	
	
	
	
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<User> findUser(String name) throws UserException {
		// TODO Auto-generated method stub
		return userMapper.findUser(name);
	}	
	public List<User> getUserMap(String name) throws UserException {
		// TODO Auto-generated method stub
		return userMapper.getUserMap(name);
	}
	public List<User> getUserHasMap(Map<String, String> map) throws UserException {
		// TODO Auto-generated method stub
		return userMapper.getUserHasMap(map);
	}
	public List<User> findAllUser() throws UserException {
		// TODO Auto-generated method stub
		return userMapper.findAllUser();
	}

}
