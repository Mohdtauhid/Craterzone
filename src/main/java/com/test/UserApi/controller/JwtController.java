package com.test.UserApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.UserApi.model.JwtRequest;
import com.test.UserApi.model.JwtResponse;
import com.test.UserApi.service.MyUserDetailService;
import com.test.UserApi.util.JwtUtil;

@RestController
public class JwtController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired 
	private MyUserDetailService detailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/token")
	private ResponseEntity<?> generatetoken(@RequestBody  JwtRequest jwtRequest) throws Exception
	{
		System.out.println(jwtRequest);
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
			}
		catch (UsernameNotFoundException e)
		{
			e.printStackTrace();
			throw new Exception("Bad Cedentials");
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Cedentials");

		}
		
	UserDetails userDetails =	this.detailsService.loadUserByUsername(jwtRequest.getUsername());
	
			String token = this.jwtUtil.generateToken(userDetails);
			System.out.println("JWT"+token);
			
			return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
}