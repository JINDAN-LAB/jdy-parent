package com.eureka.controller;

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

//	private static final String REST_URL_PREFIX = "http://kong01.com:8001";
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT:8001";

	/**
	 * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
	 * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
	@Autowired
	private RestTemplate restTemplate;

//	@RequestMapping(value = "/consumer/dept/add")
//	public Dept add(Dept dept)
//	{
//		return restTemplate.getForObject(REST_URL_PREFIX + "/ceshi-toupiao/index", Dept.class);
//	}
//	@RequestMapping(value = "/consumer/dept/get/{id}")
//	public Dept get(@PathVariable("id") Long id)
//	{
//		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
//	}
//@SuppressWarnings("unchecked")
//@RequestMapping(value = "/consumer/dept/list")
//public List<Dept> list()
//{
//	return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
//}
	@GetMapping(value = "/index")
	public String getindex()
	{
		System.out.println("============");
//		System.out.println(restTemplate.getForObject(REST_URL_PREFIX + "/ceshi-toupiao/index",String.class));
		return restTemplate.getForObject(REST_URL_PREFIX + "/ceshi-toupiao/index",String.class);
	}

	// 测试@EnableDiscoveryClient,消费端可以调用服务发现
	@RequestMapping(value = "/consumer/dept/discovery")
	public Object discovery()
	{
		return restTemplate.getForObject(REST_URL_PREFIX + "/ceshi-toupiao/index", Object.class);
	}


}
