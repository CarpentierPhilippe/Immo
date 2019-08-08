package com.edu.realestate.dao;

import java.util.List;

import com.edu.realestate.model.AdStatus;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.City;
import com.edu.realestate.model.User;

public interface AdvertisementDao extends AbstractDao<Advertisement>{

	public List<Advertisement> findLastestAds();

	public List<Advertisement> findBestAds();

	public List<Advertisement> readAll(City city);

	public List<Advertisement> readAll(AdStatus status);

	public List<Advertisement> readAllByFav(User u);

	public List<Advertisement> readAllByOwner(User u);

	public void validateAdvertisement(int adId);

	public void changeStatusAdv(int adId, AdStatus validated);

	public void changeStatusAdv(int adId, AdStatus refused, String refusedComment);

}
