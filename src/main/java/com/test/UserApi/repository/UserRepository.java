package com.test.UserApi.repository;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.UserApi.dao.AddressDao;
import com.test.UserApi.dao.UserDao;


public interface UserRepository extends JpaRepository<UserDao, Integer> 
{
	UserDao findByEmail(String email); 
	UserDao findByName(String name); 
}


