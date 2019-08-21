package com.edu.realestate.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Parking extends RealEstate {

	@Override
	public String toString() {
		return "Parking [id=" + id + ", price=" + price + ", area=" + area + ", available=" + available + "]";
	}

}
