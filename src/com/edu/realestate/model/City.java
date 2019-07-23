package com.edu.realestate.model;

public final class City {

	private int id;
	private String name;
	private String postcode;
	private double longitude;
	private double latitude;

	public City() {};

	
	public City(int id) {
		super();
		this.id = id;
	}


	public City(int id, String name, String postcode, double longitude, double latitude) {
		this.setId(id);
		this.setName(name);
		this.setPostcode(postcode);
		this.setLongitude(longitude);
		this.setLatitude(latitude);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
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
		if (!(obj instanceof City))
			return false;
		City other = (City) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", postcode=" + postcode + ", longitude=" + longitude
				+ ", latitude=" + latitude + "]";
	}
}
