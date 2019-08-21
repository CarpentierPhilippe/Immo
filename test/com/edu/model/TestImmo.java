package com.edu.model;

import com.edu.realestate.model.Apartment;
import com.edu.realestate.model.City;
import com.edu.realestate.model.RealEstate;

public class TestImmo {

	public static void main(String[] args) {
		RealEstate re = new Apartment(1);
		re.setArea((short)100);
		re.setPrice(200000);
		
		City c = new City();
		c.setName("Souriscity");
		
		re.setCity(c);
		
		System.out.println(re.getId());
		
		
	}

}


