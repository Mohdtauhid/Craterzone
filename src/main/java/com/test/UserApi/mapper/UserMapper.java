package com.test.UserApi.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.test.UserApi.dao.AddressDao;
import com.test.UserApi.dao.MobileNumberDao;
import com.test.UserApi.dao.UserDao;
import com.test.UserApi.model.Address;
import com.test.UserApi.model.MobileNumber;
import com.test.UserApi.model.User;
@Component
public class UserMapper {
	
	private ModelMapper modelMapper=new ModelMapper();
	                                 
	public User DaoToModel(UserDao userDao)
	{
		User user = modelMapper.map(userDao,User.class);  										//(Source ,target)
		return user;
	}

	public List<User> DaoToModel(List<UserDao> list)
	{
		return list.stream().map(x -> DaoToModel(x)).collect(Collectors.toList());
	}
	
	
	public UserDao ModelToDao(User user)
	{
		UserDao userDao = modelMapper.map(user,UserDao.class);
		return userDao;
	}
	
	public List<UserDao> ModelToDao(List<User> list)
	{
		return list.stream().map(x -> ModelToDao(x)).collect(Collectors.toList());
	}
 
}
