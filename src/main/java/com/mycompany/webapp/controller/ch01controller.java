package com.mycompany.webapp.controller;




import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ch01controller {
	
	private static final Logger logger = LogManager.getLogger(ch01controller.class);

	@RequestMapping("/ch01/content")
	public String content(){
		logger.info("실행");
		return "ch01/content";
	}
}
