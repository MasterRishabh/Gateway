package com.digiAds.gateway.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;

@Component
public class Test {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	
	@PostConstruct
	public void init() {
		System.out.println("########Test:" +authenticationManager);
	}

}
