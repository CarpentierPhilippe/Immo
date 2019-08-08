package com.edu.realestate.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.edu.realestate.model.AdStatus;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.City;
import com.edu.realestate.model.User;

public class AdvertisementDaoJDBC extends AbstractDaoJDBC implements AdvertisementDao {

	@Override
	public void create(Advertisement t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Advertisement read(Integer id) {
		Advertisement adv = null;
		try {
			Statement st = getConnection().createStatement();
			String sql = "SELECT * from advertisement where id = "+id;
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				//adv = AdvertisementMapper.resultToAdvertisement(rs);
			}
		} catch (Exception e) {
		}
		return adv;
	}

	@Override
	public List<Advertisement> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Advertisement t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Advertisement> findLastestAds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertisement> findBestAds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertisement> readAll(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertisement> readAll(AdStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertisement> readAllByFav(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertisement> readAllByOwner(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validateAdvertisement(int adId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStatusAdv(int adId, AdStatus validated) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStatusAdv(int adId, AdStatus refused, String refusedComment) {
		// TODO Auto-generated method stub
		
	}

}
