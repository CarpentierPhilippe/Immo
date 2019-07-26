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

public class SearchDaoJDBC extends AbstractDaoJDBC implements SearchDao {
	
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
				RealEstate re = redao.read(reid);
				
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
