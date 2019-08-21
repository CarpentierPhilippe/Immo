package com.edu.realestate.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


import com.edu.realestate.convert.BooleanToStringConverter;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class House extends NiceEstate {

	@Column (name="land_area")
	private Integer landArea;
	@Convert(converter=BooleanToStringConverter.class)
	private Boolean cellar;
	@Convert(converter=BooleanToStringConverter.class)
	private Boolean alarm;
	@Convert(converter=BooleanToStringConverter.class)
	@Column (name="swimming_pool")
	private Boolean swimmingPool;


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


	public void setLandArea(int landArea) {
		this.landArea = landArea;
	}

	@Override
	public String toString() {
		return "House [landArea=" + landArea 
				+ ", cellar=" + cellar 
				+ ", alarm=" + alarm + ", swimmingPool=" + swimmingPool 
				+ super.toString() + "]";
	}
}
