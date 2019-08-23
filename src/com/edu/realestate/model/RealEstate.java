package com.edu.realestate.model;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.edu.realestate.convert.BooleanToStringConverter;

@Entity
@Table (name="real_estate")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class RealEstate {
	
	// ATTRIBUTS
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;
	protected Integer price;
	protected Integer area;
	@Convert(converter=BooleanToStringConverter.class)
	protected Boolean available;
	@ManyToOne @JoinColumn(name="city_id")
	private City city;

	// CONSTRUCTEURS
	public RealEstate() {}
	
	public RealEstate(int id) {
		this.id = id;
	}
	
	public RealEstate(int id, int price, int area, boolean available, City city) {
		this.id = id;
		this.price = price;
		this.area = area;
		this.available = available;
		this.city = city;
	}

	// GETTERS / SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RealEstate))
			return false;
		RealEstate other = (RealEstate) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " id=" + id + ", price=" + price + ", area=" + area + ", available=" + available + ", city="
				+ city;
	}
	
	
}
