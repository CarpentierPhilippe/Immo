package com.edu.realestate.services;

import java.util.List;

import com.edu.realestate.dao.ISearchDAO;
import com.edu.realestate.dao.SearchDaoJDBC;
import com.edu.realestate.exceptions.RealEstateException;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.City;
import com.edu.realestate.model.SearchCriteria;

public class ReferenceServiceImpl implements ReferenceService {

	ISearchDAO searchDao;
	
	public ReferenceServiceImpl() {
		searchDao = new SearchDaoJDBC();
	}
	@Override
	public List<City> findCitiesByName(String input) throws RealEstateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertisement> findAdsByCriteria(SearchCriteria criteria) throws RealEstateException {
		// TODO Auto-generated method stub
		return searchDao.search(criteria);
	}

	@Override
	public List<City> listCities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void register(City city) {
		// TODO Auto-generated method stub
		
	}

}
