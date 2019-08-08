package com.edu.realestate.services;

import java.util.List;

import com.edu.realestate.exceptions.RealEstateException;
import com.edu.realestate.model.AdStatus;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.City;
import com.edu.realestate.model.Picture;
import com.edu.realestate.model.User;

public interface AdvertisementService {
	
		
	Advertisement findAdvertisementById(int id) throws RealEstateException;
	
	List<Advertisement> findAdvertisementByStatus(AdStatus status) throws RealEstateException;

	void placeAdvertisement(Advertisement ad) throws RealEstateException;
	
	List<Picture> findPictureByAdId(int aid) throws RealEstateException;

	List<Advertisement> findLastestAds() throws RealEstateException;
	
	List<Advertisement> findBestAds() throws RealEstateException;

	List<Advertisement> findAdvertisements(City city) throws RealEstateException;
	
	List<Advertisement> findFavorite(User u) throws RealEstateException;

	List<Advertisement> findOwnAds(User u) throws RealEstateException;
	
	void updateAdvertisement(Advertisement ad) throws RealEstateException;
	
	void deleteAdvertisement(Advertisement ad) throws RealEstateException;
}