package com.edu.realestate.services;

import java.util.List;

import com.edu.realestate.dao.AdvertisementDao;
import com.edu.realestate.dao.AdvertisementDaoJDBC;
import com.edu.realestate.dao.UserDao;
import com.edu.realestate.dao.UserDaoJDBC;
import com.edu.realestate.exceptions.RealEstateException;
import com.edu.realestate.model.AdStatus;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.User;

public class ModeratorServiceImpl implements ModeratorService {

	AdvertisementDao advertisementDao = new AdvertisementDaoJDBC();
	UserDao userDao = new UserDaoJDBC();
	
	@Override
	public void validateAdvertisement(int adId) {
		advertisementDao.changeStatusAdv(adId, AdStatus.Validated);
		
	}

	@Override
	public void refuseAdvertisement(int adId, String refusedComment) {
		advertisementDao.changeStatusAdv(adId, AdStatus.Refused, refusedComment);
		
	}

	@Override
	public List<Advertisement> findAdvertisementsByStatus(AdStatus status) throws RealEstateException {
		List<Advertisement> advs = advertisementDao.readAll(status);
		return advs;
	}

	@Override
	public void updateAdvertisement(Advertisement ad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAdvertisement(Advertisement ad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

}
