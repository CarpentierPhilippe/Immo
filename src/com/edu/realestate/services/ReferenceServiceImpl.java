package com.edu.realestate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.realestate.dao.SearchDao;
import com.edu.realestate.exceptions.RealEstateException;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.City;
import com.edu.realestate.model.SearchCriteria;

@Repository
public class ReferenceServiceImpl implements ReferenceService {

	@Autowired
	SearchDao searchDao;
	

	@Override
	public List<City> findCitiesByName(String cityName) throws RealEstateException {
		List<City> cities = searchDao.search(cityName);
		return cities;
	}

	@Override
	public List<Advertisement> findAdsByCriteria(SearchCriteria criteria) throws RealEstateException {
		List<Advertisement> advs = searchDao.search(criteria);
		return advs;
	}

	@Override
	public List<City> listCities() {
		List<City> cities = searchDao.search();
		return cities;
	}
	@Override
	public void register(City city) {
		searchDao.register(city);
	}

}
