package com.test.UserApi.model;

public class JwtResponse 
{
	String token;
	public JwtResponse() 
	{
		super();
	}

	public JwtResponse(String token) 
	{
		this.token = token;
	}

	public String getToken() 
	{
		return token;
	}

	public void setToken(String token) 
	{
		this.token = token;
	}
}