package com.mycompany.webapp.service;


import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mycompany.webapp.dao.MemberDao;



@Service
public class MemberService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	public MemberService() {
		logger.info("실행");
	}
}
