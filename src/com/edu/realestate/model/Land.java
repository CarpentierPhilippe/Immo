package com.edu.realestate.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Land extends RealEstate {

	@Override
	public String toString() {
		return "Land [" + super.toString() + "]";
	}

}
