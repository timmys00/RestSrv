package com.mic3.controllers;

import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mic3.domain.City;
import com.mic3.exceptions.CityNotFoundException;
import com.mic3.services.CityService;

@RestController
@RequestMapping("/cities")
public class CitiesController {

	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		this.cityService = cityService;
	}
	
	// FIND ALL
	@RequestMapping(method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Callable<List<City>> findAllCities() {
//	public @ResponseBody List<City> findAllCities() {
		Callable<List<City>> asyncTask = new Callable<List<City>>() {
			 
		      @Override
		      public List<City> call() throws Exception {
		        return cityService.getAllCities();
		      }
		      
		    };
		     
		return asyncTask;
	}
		
	@RequestMapping(value="/{country}", method=RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Callable<List<City>> getCountrySpecific(@PathVariable("country") String country) {
		Callable<List<City>> asyncTask = new Callable<List<City>>() {
			 List<City> toReturn;
		      @Override
		      public List<City> call() throws Exception {
		    	  toReturn = cityService.getCitiesInCountry(country);
		    	  if(toReturn.isEmpty())
		    		  throw new CityNotFoundException();
		    	  
		        return cityService.getCitiesInCountry(country);
		      }
		      
		    };
		     
		return asyncTask;
	}
	
}