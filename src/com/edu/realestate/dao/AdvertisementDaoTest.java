package com.edu.realestate.dao;


import java.util.ArrayList;
import java.util.List;

import com.edu.realestate.model.AdStatus;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.City;
import com.edu.realestate.model.User;

public class AdvertisementDaoTest implements AdvertisementDao {


	private static ArrayList<Advertisement> listeAdv = new ArrayList<Advertisement>();
	
	public AdvertisementDaoTest() {
		Advertisement adv = new Advertisement();
		adv.setTitle("AdvTest");
		listeAdv.add(adv);
		adv.setTitle("Last");
		listeAdv.add(adv);
		adv.setTitle("Best");
		listeAdv.add(adv);
	}
	
	@Override
	public void create(Advertisement t) {
		System.out.println("Create adv");

	}

	@Override
	public Advertisement read(Integer id) {
		return listeAdv.get(0);
	}

	@Override
	public List<Advertisement> readAll() {
		return listeAdv;
	}

	@Override
	public void update(Advertisement t) {
		System.out.println("Update");
	}

	@Override
	public void delete(Integer id) {
		System.out.println("delete");
	}

	@Override
	public List<Advertisement> findLastestAds() {
		return listeAdv;
	}

	@Override
	public List<Advertisement> findBestAds() {
		return listeAdv;
	}

	@Override
	public List<Advertisement> readAll(City city) {
		return listeAdv;
	}

	@Override
	public List<Advertisement> readAll(AdStatus status) {
		return listeAdv;
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
