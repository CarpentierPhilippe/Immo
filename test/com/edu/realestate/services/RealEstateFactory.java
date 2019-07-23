package com.edu.realestate.services;

import java.util.Random;

import com.edu.realestate.model.*;

public class RealEstateFactory {
	RealEstate getRealEstate(RealEstateType type) {
		RealEstate realEstate = null;
		switch(type) {
			case House :
				House h= new House();
				h.setAlarm(true);
				h.setRooms(10);
				//etc
				h.setPrice(300);
				realEstate = h;
				break;
			case Apartment :
				Apartment a = new Apartment();
				a.setPrice(500000);
				realEstate = a;
				break;
			case Parking :
				Parking p = new Parking();
				p.setPrice(1000000);
				realEstate = p;
				break;
			default :
				System.out.println("prob");
		}
		if (realEstate!=null) {
			Random r = new Random();
			int fakeId = r.nextInt(100000);
			realEstate.setId(fakeId);
		}
		return realEstate;
		
	}
}
