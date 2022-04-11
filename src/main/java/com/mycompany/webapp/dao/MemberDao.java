package com.mycompany.webapp.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	

	private static final Logger logger = LogManager.getLogger(MemberDao.class);
	
	public MemberDao() {
		logger.info("실행");
		
	}

}
