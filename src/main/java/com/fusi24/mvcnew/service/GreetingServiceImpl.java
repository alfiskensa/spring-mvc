package com.fusi24.mvcnew.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingsService{

	@Override
	public String createGreeting(String greeting) {
		// TODO Auto-generated method stub
		return "hey, my name is "+greeting;
	}
	
	
}
