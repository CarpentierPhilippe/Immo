package com.edu.realestate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edu.realestate.model.City;

public class CityDaoJDBC extends AbstractDaoJDBC implements ICityDAO  {

	@Override
	public void create(City city) {
		// TODO Auto-generated method stub

	}

	@Override
	public City read(Integer id) {
		City result = null;
		try {
			Statement st = getConnection().createStatement();
			String sql = "SELECT * from city where id ="+id;
			ResultSet rs = st.executeQuery(sql);
			
			City city = null;
			if (rs.next()) {
				city = new City();
				city.setId(rs.getInt("id"));
				city.setName(rs.getString("name"));
				city.setPostcode(rs.getString("postcode"));
				city.setLongitude(rs.getDouble("latitude"));
				city.setLatitude(rs.getDouble("latitude"));
				result = city;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void update(City city) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<City> readAll() {
		List<City> result = new ArrayList<City>();
		try {
			Statement st = getConnection().createStatement();
			String sql = "SELECT * from city";
			ResultSet rs = st.executeQuery(sql);
			
			City city = null;
			while (rs.next()) {
				city = new City();
				city.setId(rs.getInt("id"));
				city.setName(rs.getString("name"));
				city.setPostcode(rs.getString("postcode"));
				city.setLongitude(rs.getDouble("latitude"));
				city.setLatitude(rs.getDouble("latitude"));
				result.add(city);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
