package com.edu.realestate.services;

import java.util.List;

import com.edu.realestate.dao.CityDao;
import com.edu.realestate.dao.SearchDao;
import com.edu.realestate.dao.SearchDaoJDBC;
import com.edu.realestate.exceptions.RealEstateException;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.City;
import com.edu.realestate.model.SearchCriteria;

public class ReferenceServiceImpl implements ReferenceService {

	SearchDao searchDao;
	CityDao cityDao;
	
	public ReferenceServiceImpl() {
		searchDao = new SearchDaoJDBC();
		
	}
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
