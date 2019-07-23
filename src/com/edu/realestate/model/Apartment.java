package com.edu.realestate.model;

public class Apartment extends NiceEstate {

	private int rooms;
	private String floor;
	private boolean elevator;
	private boolean intercom;
	private boolean balcony;
	private boolean terrace;
	private boolean garage;
	private boolean parking;
	private boolean alarm;
	private boolean digicode;

	public Apartment() {
		super();
	}

	
	public Apartment(Integer rooms) {
		super();
		this.rooms = rooms;
	}


	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public boolean isElevator() {
		return elevator;
	}

	public void setElevator(boolean elevator) {
		this.elevator = elevator;
	}

	public boolean isIntercom() {
		return intercom;
	}

	public void setIntercom(boolean intercom) {
		this.intercom = intercom;
	}

	public boolean isBalcony() {
		return balcony;
	}

	public void setBalcony(boolean balcony) {
		this.balcony = balcony;
	}

	public boolean isTerrace() {
		return terrace;
	}

	public void setTerrace(boolean terrace) {
		this.terrace = terrace;
	}

	public boolean isGarage() {
		return garage;
	}

	public void setGarage(boolean garage) {
		this.garage = garage;
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public boolean isAlarm() {
		return alarm;
	}

	public void setAlarm(boolean alarm) {
		this.alarm = alarm;
	}

	/**
	 * Checks if is digicode.
	 *
	 * @return true, if is digicode
	 */
	public boolean isDigicode() {
		return digicode;
	}

	/**
	 * Sets the digicode.
	 *
	 * @param digicode the new digicode
	 */
	public void setDigicode(boolean digicode) {
		this.digicode = digicode;
	}

	@Override
	public String toString() {
		return "Appartement [rooms=" + rooms + ", floor=" + floor + ", energyLevel=" + energyLevel + ", gasLevel="
				+ gasLevel + ", elevator=" + elevator + ", intercom=" + intercom + ", balcony=" + balcony + ", terrace="
				+ terrace + ", garage=" + garage + ", parking=" + parking + ", alarm=" + alarm + ", digicode="
				+ digicode + ", id=" + id + ", price=" + price + ", area=" + area + ", available=" + available + "]";
	}


}
