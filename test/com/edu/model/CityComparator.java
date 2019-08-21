package com.edu.model;

import java.util.Comparator;

import com.edu.realestate.model.City;

public class CityComparator implements Comparator<City> {

	@Override
	public int compare(City c1, City c2) {
		int r = c1.getId() - c2.getId();
		if (r!=0) return r;
		return c1.getName().compareTo(c2.getName());
	}
}
