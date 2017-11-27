package com.example.om;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class OMapper{
	
	@Autowired
	private ObjectMapper om;
	
	@Bean
	@Primary
	public ObjectMapper OMclass() {
		return new ObjectMapper();
	}

	

}
