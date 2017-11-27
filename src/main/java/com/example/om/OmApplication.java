package com.example.om;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class OmApplication {
	
	private static final Logger log = LoggerFactory.getLogger(OmApplication.class);
	
//	@Autowired
//	private static ObjectMapper om;

	public static void main(String[] args) throws IOException {
		ApplicationContext context = SpringApplication.run(OmApplication.class, args);
		//ObjectMapper om = (ObjectMapper)context.getBean(ObjectMapper.class);
		
		ObjectMapper om = (ObjectMapper)context.getBean("OMclass");
		
		Person p = new Person(21,"zss");
		
		System.out.println( om.writeValueAsString(p) );
		
		String json = "{\"id\":20,\"name\":\"zs\"}";
		
		Person personJson = om.readValue(json, Person.class);
		
		System.out.println(personJson);
			
	}
	



	
}
