package com.edu.realestate.dao;

import java.util.List;

import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.City;
import com.edu.realestate.model.SearchCriteria;

public interface SearchDao {

	List<Advertisement> search(SearchCriteria criteria);

	List<City> search(String cityName);

	List<City> search();

	void register(City city);

}
