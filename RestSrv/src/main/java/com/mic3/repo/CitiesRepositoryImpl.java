package com.mic3.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.mic3.domain.City;
import com.mic3.exceptions.ResourceNotFoundExc;

@Repository
public class CitiesRepositoryImpl implements CitiesRepository {

	private ConcurrentHashMap<Integer, City> all;
	
	public CitiesRepositoryImpl(){
		all = new ConcurrentHashMap();
	}
	
	public void FillRepository(ResultSet rs){
		
		try {
			int rows = 0;
			if (rs.last()) {
			  rows = rs.getRow();
			  rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
			}
			City city;
			
			for(int i=1; rows>=i; i++){
				if(rs.next()){
					city = new City(
							rs.getString("country"), rs.getString("city"), 
							rs.getString("accent"), rs.getString("region"),
							rs.getDouble("population"), rs.getDouble("longitude"), 
							rs.getDouble("latitude"));
					
					this.all.put(i, city);
				}
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ConcurrentHashMap<Integer, City> findSpecific(String country) {
		ConcurrentHashMap<Integer, City> toReturn = (ConcurrentHashMap<Integer, City>) this.all.entrySet()
		.stream().filter(e -> e.getValue().getCountry().equalsIgnoreCase(country))
		.collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));

		return toReturn;
	}

	public ConcurrentHashMap<Integer, City> findAll() {
		return this.all;
	}

}
