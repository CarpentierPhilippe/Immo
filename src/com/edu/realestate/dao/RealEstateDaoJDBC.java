package com.edu.realestate.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.edu.realestate.mapping.RealEstateMapper;
import com.edu.realestate.model.*;

public class RealEstateDaoJDBC extends AbstractDaoJDBC implements IRealEstateDAO {

	@Override
	public void create(RealEstate t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RealEstate read(Integer id) {

		
		RealEstate re = null;
		try {
			String query = "SELECT typeBien from allproperties WHERE id ="+id;
			Statement st = getConnection().createStatement();
			ResultSet rs = st.executeQuery(query);
			String tableName = null;
			String typeBien = null;
			if (rs.next()) {
				typeBien = rs.getString("typeBien");
				tableName=RealEstateMapper.tableFromType(typeBien);
			}
			if (tableName!=null) {
				String query2= "SELECT r.*, b.* from real_estate r JOIN "+tableName+" b ON r.id = b.id";
				Statement st2 = getConnection().createStatement();
				ResultSet rs2 = st2.executeQuery(query2);
				if(rs2.next()) {
					re = RealEstateMapper.resultToRealEstate(rs2, typeBien);
					ICityDAO cdao = new CityDaoJDBC();
					City city = cdao.read(rs2.getInt("city_id"));
					re.setCity(city);
				}
			}
		}catch (Exception e) {
			e.getLocalizedMessage();
		}
		
		return re;
	}

	@Override
	public List<RealEstate> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(RealEstate t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
