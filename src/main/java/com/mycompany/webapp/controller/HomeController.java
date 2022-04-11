package com.mycompany.webapp.controller;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//Dispatcher에 home 전달
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LogManager.getLogger(HomeController.class);
	

	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		logger.info("실행");
		
		///WEB-INF/views/home.jsp
		return "home";
	}
	
	
}
