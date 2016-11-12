package com.mic3.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mic3.domain.City;

@Repository
@Transactional
public class CitiesRepositoryImpl extends AbstractRepository<Integer, City> implements CitiesRepository {

	private List<City> all;
	
	public CitiesRepositoryImpl(){
		all = new ArrayList<>();
	}
	
	public List<City> findSpecific(String country) {
		Criteria criteria = createEntityCriteria();
		List<City> toReturn;
		Stream<City> myStream = ((List<City>)criteria.list()).stream();
		toReturn = myStream.filter(city -> city.getCountry().equalsIgnoreCase(country))
				.collect(Collectors.toList());
		return toReturn;
	}

	public List<City> findAll() {
		Criteria criteria = createEntityCriteria();
		List<City> toReturn = (List<City>)criteria.list();
		return toReturn;
	}

}
