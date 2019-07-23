package com.edu.realestate.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.edu.realestate.model.*;

public class RealEstateMapper {

	public static String tableFromType(String typeBien) {
		String tableName;
		switch(typeBien) {
			case "APP":
				tableName = "apartment";
			break;
			case "HOUSE" :
				tableName = "house";
			break;
			case "PRK" :
				tableName = "parking";
			break;
			case "LAND" :
				tableName = "land";
			break;
			case "COMM" :
				tableName = "commercial_property";
			break;
			default:
				tableName = "other_property";
			break;
		};
		return tableName;
	}

	public static RealEstate resultToRealEstate(ResultSet rs, String typeBien) throws SQLException {
		RealEstate re = null;
		switch(typeBien) {
			case "APP":
				Apartment app = new Apartment();

				app.setRooms(rs.getInt("rooms"));
				app.setFloor(rs.getString("floor"));
				app.setEnergyLevel(rs.getString("energy_level"));
				app.setGasLevel(rs.getString("gas_level"));
				app.setElevator(rs.getString("elevator").equalsIgnoreCase("Y"));

				app.setIntercom(rs.getString("intercom").equalsIgnoreCase("Y"));
				

				app.setBalcony(rs.getString("balcony").equalsIgnoreCase("Y"));
				app.setTerrace(rs.getString("terrace").equalsIgnoreCase("Y"));
				app.setGarage(rs.getString("garage").equalsIgnoreCase("Y"));
				app.setParking(rs.getString("parking").equalsIgnoreCase("Y"));
				app.setAlarm(rs.getString("alarm").equalsIgnoreCase("Y"));
				app.setDigicode(rs.getString("digicode").equalsIgnoreCase("Y"));
				
				re = app;
			break;
			case "HOUSE" :
				System.out.println(typeBien);
				House house = new House();
				house.setRooms(rs.getInt("rooms"));
				house.setLandArea(rs.getInt("land_area"));
				house.setEnergyLevel(rs.getString("energy_level"));
				house.setGasLevel(rs.getString("gas_level"));
				house.setCellar(rs.getString("cellar").equalsIgnoreCase("Y"));
				house.setAlarm(rs.getString("alarm").equalsIgnoreCase("Y"));
				house.setSwimmingPool(rs.getString("swimming_pool").equalsIgnoreCase("Y"));		
				
				re = house;
			break;
			case "PRK" :
				System.out.println(typeBien);
				re = new Parking();
			break;
			case "LAND" :
				System.out.println(typeBien);
				re = new Land();
			break;
			case "COMM" :
				System.out.println(typeBien);
				re = new CommercialProperty();
			break;
			default :
				System.out.println(typeBien);
				re = new OtherProperty();
			break;
		};
		System.out.println("fin");
		re.setPrice(rs.getInt("price"));
		re.setArea(rs.getInt("area"));
		re.setAvailable(rs.getString("available").equalsIgnoreCase("Y"));
		return re;
	}

}
