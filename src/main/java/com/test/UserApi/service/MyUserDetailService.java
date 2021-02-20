package com.test.UserApi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.UserApi.dao.UserDao;
import com.test.UserApi.mapper.UserMapper;
import com.test.UserApi.model.User;
import com.test.UserApi.repository.UserRepository;

import io.jsonwebtoken.lang.Arrays;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		UserDao userDao = repository.findByName(username);
		User user = userMapper.DaoToModel(userDao);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),new ArrayList<>());
	}
	

}