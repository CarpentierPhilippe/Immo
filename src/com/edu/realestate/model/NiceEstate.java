package com.edu.realestate.model;

public abstract class NiceEstate extends RealEstate {

	protected String energyLevel;
	protected String gasLevel;
	
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
	
	
}
