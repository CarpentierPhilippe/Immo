package com.edu.realestate.model;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


import com.edu.realestate.convert.BooleanToStringConverter;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Apartment extends NiceEstate {

	private String floor;
	@Convert(converter=BooleanToStringConverter.class)
	private Boolean elevator;
	@Convert(converter=BooleanToStringConverter.class)
	private Boolean intercom;
	@Convert(converter=BooleanToStringConverter.class)
	private Boolean balcony;
	@Convert(converter=BooleanToStringConverter.class)
	private Boolean terrace;
	@Convert(converter=BooleanToStringConverter.class)
	private Boolean garage;
	@Convert(converter=BooleanToStringConverter.class)
	private Boolean parking;
	@Convert(converter=BooleanToStringConverter.class)
	private Boolean alarm;
	@Convert(converter=BooleanToStringConverter.class)
	private Boolean digicode;

	public Apartment() {
		super();
	}

	
	public Apartment(Integer rooms) {
		super();
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
		return "Appartement [rooms=" + rooms + ", floor=" + floor + ", elevator=" + elevator + ", intercom=" + intercom + ", balcony=" + balcony + ", terrace="
				+ terrace + ", garage=" + garage + ", parking=" + parking + ", alarm=" + alarm + ", digicode="
				+ digicode + ", id=" + id + ", price=" + price + ", area=" + area + ", available=" + available + "]";
	}


}
