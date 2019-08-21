package com.edu.realestate.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="id")
@Table (name = "commercial_property")
public class CommercialProperty extends RealEstate {

	@Override
	public String toString() {
		return "CommercialProperty " + super.toString();
	}
}
