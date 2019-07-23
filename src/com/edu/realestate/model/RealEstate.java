package com.edu.realestate.model;

public abstract class RealEstate {
	
	// ATTRIBUTS
	protected int id;
	protected int price;
	protected int area;
	protected boolean available;
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
