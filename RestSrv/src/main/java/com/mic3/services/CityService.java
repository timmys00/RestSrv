package com.mic3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mic3.domain.City;
import com.mic3.repo.CitiesRepository;

@Service
@Transactional
public class CityService {
	
	@Autowired
	CitiesRepository citiesRepository;
	
	@Cacheable(value = "citiesCache")
	public List<City> getAllCities() {
		return citiesRepository.findAll();
	  }
	
	@Cacheable(value = "citiesCache")
	public List<City> getCitiesInCountry(String country) {
		return citiesRepository.findSpecific(country);
	  }

}
