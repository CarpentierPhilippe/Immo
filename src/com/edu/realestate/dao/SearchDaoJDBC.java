package com.edu.realestate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.Advertiser;
import com.edu.realestate.mapping.AdvertiserMapper;
import com.edu.realestate.model.RealEstate;
import com.edu.realestate.model.SearchCriteria;

public class SearchDaoJDBC extends AbstractDaoJDBC implements ISearchDAO {
	
	@Override
	public List <Advertisement> search(SearchCriteria criteria){
		
		UserDaoJDBC udao = new UserDaoJDBC();
		RealEstateDaoJDBC redao = new RealEstateDaoJDBC();
		
		List<Advertisement> advs = new ArrayList<>();
		try {
			
			Integer id = criteria.getCityId();
			Statement st = getConnection().createStatement();
			String query = "SELECT * from advertisement a JOIN real_estate r "
					+ "on (a.real_estate_id = r.id) WHERE r.city_id ="+id;
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				
				String aid = rs.getString("advertiser_id");
				Advertiser ad = (Advertiser) udao.read(aid);
				int reid = rs.getInt("real_estate_id");
				RealEstate re = null; //redao.read(reid);
				
				//Map
				Advertisement adv = AdvertiserMapper.resultToAdv(rs, ad, re);
				advs.add(adv);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return advs;		
	}
}


//query = "SELECT * from allproperties a WHERE id ="+reid;
//ResultSet typeBien = st.executeQuery(query);
//if (typeBien.next()) {
//	String tb = typeBien.getString("typeBien");
//	RealEstate re = null;
//	switch(tb) {
//		case "APP":
//			re = new Apartment();
//		break;
//		case "HOUSE" :
//			re = new House();
//		break;
//		case "PRK" :
//			re = new Parking();
//		break;
//		case "LAND" :
//			re = new Land();
//		break;
//		case "COMM" :
//			re = new OtherProperty();
//		break;
//	};
//	adv.setRealEstate(re);
//}
