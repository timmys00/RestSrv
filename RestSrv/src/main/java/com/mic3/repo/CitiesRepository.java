package com.mic3.repo;

import java.util.List;

import com.mic3.domain.City;


public interface CitiesRepository {
	List<City> findSpecific(String country);
	List<City> findAll();
}
