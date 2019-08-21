package com.edu.realestate.model;

import javax.persistence.Column;

public abstract class NiceEstate extends RealEstate {

	
	protected Integer rooms;
	@Column (name="energy_level")
	private String energyLevel;
	@Column (name="gas_level")
	private String gasLevel;
	
	public String getEnergyLevel() {
		return energyLevel;
	}
	
	public void setEnergyLevel(String energyLevel) {
		this.energyLevel = energyLevel;
	}
	public String getGasLevel() {
		return gasLevel;
	}
	public void setGasLevel(String gasLevel) {
		this.gasLevel = gasLevel;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "NiceEstate [rooms=" + rooms + ", energyLevel=" + energyLevel + ", gasLevel=" + gasLevel + super.toString()+ "]";
	}
	
	
}
