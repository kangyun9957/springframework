package com.mycompany.webapp.controller;

import java.util.Date;



import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.webapp.dto.Ch03Dto;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/ch03")
@Log4j2
public class Ch03Controller {
	@RequestMapping("/content")
	public String content() {
		log.info("실행");
		return "ch03/content";
	}
	
	@GetMapping("/method1")//RequestParam을 이용해서 변수명 체인지
	public String method1(@RequestParam("param1") String arg1,int param2,double param3,boolean param4,@DateTimeFormat(pattern="yyyy-MM-dd") Date param5) {
		log.info(arg1);
		log.info(param2);
		log.info(param3);
		log.info(param4);
		log.info(param5);
		
		return "ch03/content";
		
	}
	
	@PostMapping("/method2")
	public String method2(String param1,int param2,double param3,boolean param4,@DateTimeFormat(pattern="yyyy-MM-dd") Date param5) {
		log.info(param1);
		log.info(param2);
		log.info(param3);
		log.info(param4);
		log.info(param5);
		return "ch03/content";
		
	}
	
	@RequestMapping("/method3")//required=true 뜻은 param1은 반드시 넘어와야 한다는 뜻
	public String method3(@RequestParam(required=true)String param1,String param2) {
		log.info(param1);
		log.info(param2);
		return "ch03/content";
	}
	@RequestMapping("/method4")
	public String method4(
			String param1,
			@RequestParam(defaultValue="0")int param2,
			@RequestParam(defaultValue="0.0")double param3,
			@RequestParam(defaultValue="false")boolean param4) {
		log.info(param1);
		log.info(param2);
		log.info(param3);
		log.info(param4);
		return "ch03/content";
	}
	@RequestMapping("/method5")
	public String method5(Ch03Dto dto) {
		log.info(dto.getParam1());
		log.info(dto.getParam2());
		log.info(dto.getParam3());
		log.info(dto.isParam4());
		log.info(dto.getParam5());
		return "ch03/content";
	}
	
	
}