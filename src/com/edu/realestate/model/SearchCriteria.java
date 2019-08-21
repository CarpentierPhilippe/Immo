package com.edu.realestate.model;

public class SearchCriteria {
	
	private int cityId;
	private String query; //where description like %query% or title like %query%
	private String type; //transaction type
	private int priceMin; // A exclure si abherant (ou 0)
	private int priceMax; // A exclure si abherant (ou 0)
	private int areaMin; // A exclure si abherant (ou 0)
	private int areaMax; // A exclure si abherant (ou 0)
	private double longitude;
	private double latitude;
	private int distance; //en km autour de cityID
	
	
	@Override
	public String toString() {
		return "SearchCriteria [cityId=" + cityId + ", query=" + query + ", type=" + type + ", priceMin=" + priceMin
				+ ", priceMax=" + priceMax + ", areaMin=" + areaMin + ", areaMax=" + areaMax + "]";
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getQuery() {
		if (query != null)
			query.trim();
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPriceMin() {
		return priceMin;
	}
	public void setPriceMin(int priceMin) {
		this.priceMin = priceMin;
	}
	public int getPriceMax() {
		return priceMax;
	}
	public void setPriceMax(int priceMax) {
		this.priceMax = priceMax;
	}
	public int getAreaMin() {
		return areaMin;
	}
	public void setAreaMin(int areaMin) {
		this.areaMin = areaMin;
	}
	public int getAreaMax() {
		return areaMax;
	}
	public void setAreaMax(int areaMax) {
		this.areaMax = areaMax;
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
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	
}
