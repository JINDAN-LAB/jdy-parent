package com.eureka.fegin.controller;

import atsliyun.entities.Dept;
import atsliyun.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer
{
	@Autowired
	private DeptClientService service ;

	@GetMapping(value = "/ceshi-toupiao/index")
	public String get(){
		System.out.println("------------");
		System.out.println(";;;;;");
		return this.service.get();
	}


}
