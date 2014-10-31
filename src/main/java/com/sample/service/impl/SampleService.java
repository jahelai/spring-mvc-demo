package com.sample.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sample.dao.ISampleDao;
import com.sample.service.ISampleService;

@Service
public class SampleService implements ISampleService {
	
	private final static  Logger log = LoggerFactory.getLogger(SampleService.class);
	private ISampleDao sampleDao;

	public void setSampleDao(ISampleDao sampleDao) {
		this.sampleDao = sampleDao;
	}

	@Override
	public void getSomething() {
		log.debug("dddddddddddddd");
		this.sampleDao.getId();
		
	}
	
	

}
