package com.edu.realestate.model;

public class House extends NiceEstate {

	private int rooms;
	private int landArea;
	private boolean cellar;
	private boolean alarm;
	private boolean swimmingPool;

	public Integer getRooms() {
		return rooms;
	}

	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}

	public Integer getLandArea() {
		return landArea;
	}

	public void setLandArea(Integer landArea) {
		this.landArea = landArea;
	}

	public boolean isCellar() {
		return cellar;
	}

	public void setCellar(boolean cellar) {
		this.cellar = cellar;
	}

	public boolean isAlarm() {
		return alarm;
	}

	public void setAlarm(boolean alarm) {
		this.alarm = alarm;
	}

	public boolean isSwimmingPool() {
		return swimmingPool;
	}

	public void setSwimmingPool(boolean swimmingPool) {
		this.swimmingPool = swimmingPool;
	}

	@Override
	public String toString() {
		return "House [rooms=" + rooms + ", energyLevel=" 
				+ energyLevel + ", landArea=" + landArea 
				+ ", gasLevel=" + gasLevel + ", cellar=" + cellar 
				+ ", alarm=" + alarm + ", swimmingPool=" + swimmingPool 
				+ super.toString() + "]";
	}
}
