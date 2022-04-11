package com.mycompany.webapp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.MemberDao;



@Service
public class MemberService {
	
	
	private static final Logger logger = LogManager.getLogger(MemberService.class);
	
	public MemberService() {
		logger.info("실행");
	}
}
