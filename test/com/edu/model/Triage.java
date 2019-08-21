package com.edu.model;

import java.util.ArrayList;

import com.edu.realestate.model.City;


public class Triage {

	public static void main(String[] args) {
		

		City paris = new City(10, "Paris", "75000", 0d, 0d);
		City marseille = new City(5,"Marseille", "13000",0d,0d);
		City toulouse = new City(2,"Toulouse", "31000",0d,0d);
		City taverny = new City(1,"Taverny", "95150", 0d,0d);
		City pontoise = new City(15, "Pontoise", "95032",0d,0d);
		ArrayList<City> cities = new ArrayList<City>();
		
		City city[] = {paris, marseille, toulouse, taverny, pontoise};
		for (City c : city)
			cities.add(c);
		
		/*
		String names[] = {"Paris", "Marseille", "Toulouse", "Taverny","Pontoise"};
		int ids = 100;
		int cpStart = 75000;
		for (String name : names) {
			City c = new City(ids,name,"" + cpStart,0d,0d);
			cities.add(c);			
			ids-=10;
			cpStart +=2000;
		}
		*/
		//cities.sort(null);
		
		cities.add(null);
		
		CityComparator cc = new CityComparator();
		cities.sort(cc);
	
		
		for (City c : cities)
			System.out.println(c);
		
		
	}		
		
}
