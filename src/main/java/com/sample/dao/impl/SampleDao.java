package com.sample.dao.impl;

import org.springframework.stereotype.Repository;

import com.sample.dao.ISampleDao;

@Repository
public class SampleDao implements ISampleDao {

	@Override
	public int getId() {
		return 1;
	}

}
