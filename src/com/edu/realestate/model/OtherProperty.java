package com.edu.realestate.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="id")
@Table (name = "other_property")
public class OtherProperty extends RealEstate {

	@Override
	public String toString() {
		return "OtherProperty [id=" + id + ", price=" + price + ", area=" + area + ", available=" + available + "]";
	}

}
