package com.mic3.repo;

import java.sql.ResultSet;
import java.util.concurrent.ConcurrentHashMap;

import com.mic3.domain.City;


public interface CitiesRepository {
	ConcurrentHashMap<Integer, City> findSpecific(String country);
	ConcurrentHashMap<Integer, City> findAll();
	void FillRepository(ResultSet rs);
}
