package com.api.versioning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.versioning.model.PersonV1;
import com.api.versioning.model.PersonV2;
import com.api.versioning.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService service;
	
	// 1. URI versioning
	// http://localhost:8080/api/v1/person
	@GetMapping("/api/v1/person")
	public List<PersonV1> URIVersioning(){
		
		return service.getAllV1();
	}
	
	
	// V2 - http://localhost:8080/api/v2/person
	@GetMapping("/api/v2/person")
	public List<PersonV2> URIVersioningV2(){
		return service.getAllV2();
	}
	
	// 2. Request PARAM
	@GetMapping(path = "/api/person" , params = "version=1")
	public List<PersonV1> requestParamV1(){
		return service.getAllV1();
	}
	
	@GetMapping(value = "/api/person" , params = "version=2")
	public List<PersonV2> requestParamV2(){
		return service.getAllV2();
	}
	
	//3. Custom REQUEST HEADER
	// http://localhost:8080/api/person
	@GetMapping(path = "/api/person" , headers = "X-API-VERSION=1")
	public List<PersonV1> requestHeaderV1(){
		return service.getAllV1();
	}
	
	@GetMapping(value = "/api/person" , headers = "X-API-VERSION=2")
	public List<PersonV2> requestheaderV2(){
		return service.getAllV2();
	}
	
	//4. REQUEST ACCEPT HEADER
	// http://localhost:8080/api/person
	@GetMapping(path = "/api/person" , produces = "application/vnd.company.app-v1+json")
	public List<PersonV1> requestAcceptHeaderV1(){
		return service.getAllV1();
	}
	
	@GetMapping(value = "/api/person" , produces = "application/vnd.company.app-v2+json")
	public List<PersonV2> requestAcceptHeaderV2(){
		return service.getAllV2();
	}
	
	
}
