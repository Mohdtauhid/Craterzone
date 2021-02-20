package com.test.UserApi.service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.UserApi.dao.UserDao;
import com.test.UserApi.mapper.UserMapper;
import com.test.UserApi.model.User;
import com.test.UserApi.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private	UserRepository userRepository;
	@Autowired
	private UserMapper userMapper;

	public List<User> getUser()
	{
		List<UserDao> listDao = userRepository.findAll();
		return userMapper.DaoToModel(listDao);
	}

	public Optional<User> login(User user)
	{
	   UserDao username = userRepository.findByName(user.getName());
		if(Objects.nonNull(username))
			return Optional.ofNullable(userMapper.DaoToModel(username));
		else
			return null;
	}
	
	public Optional<User> saveUser(User user)
	{
		UserDao userExists = userRepository.findByEmail(user.getEmail());
		if(userExists!=null)
			return Optional.ofNullable(userMapper.DaoToModel(userExists));
		else
		{
			UserDao userDao = userMapper.ModelToDao(user);
			userDao=userRepository.save(userDao);
			return Optional.ofNullable(userMapper.DaoToModel(userDao));
		}
	}
	
	public Optional<User> getById(int id)
	{
		UserDao userId = userRepository.findById(id).orElse(null);
	    return Optional.ofNullable(userMapper.DaoToModel(userId));
	}

	public  boolean deleteId(int id) 
	{
    	Optional<UserDao> userDao = userRepository.findById(id);
    	
    	if(userDao.isPresent())
    	{
    		userRepository.deleteById(id);
           return true;
    	}
    	return false;
    }


		
}
		



