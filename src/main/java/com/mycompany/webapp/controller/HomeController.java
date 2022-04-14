package com.mycompany.webapp.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.dao.MemberDao;
//Dispatcher에 home 전달
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//private static final Logger logger = LogManager.getLogger(HomeController.class);
	

	@RequestMapping("/")
	public String home() {
		logger.info("실행");
		
		///WEB-INF/views/home.jsp
		return "home";
	}
	
	
}
