package com.edu.realestate.services;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.realestate.dao.AdvertisementDao;
import com.edu.realestate.exceptions.RealEstateException;
import com.edu.realestate.model.AdStatus;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.City;
import com.edu.realestate.model.Favoris;
import com.edu.realestate.model.Picture;
import com.edu.realestate.model.User;

@Repository
public class AdvertisementServiceImpl implements AdvertisementService {

	@Autowired
	private AdvertisementDao advertisementDao;
	
	@Override
	public Advertisement findAdvertisementById(int id) throws RealEstateException {
			Advertisement adv = advertisementDao.read(id);
			return adv;
	}

	@Override
	public void placeAdvertisement(Advertisement ad) throws RealEstateException {
		advertisementDao.create(ad);
		
	}

	@Override
	public List<Picture> findPictureByAdId(int aid) throws RealEstateException {
		List<Picture> pictures = advertisementDao.read(aid).getPictures();
		return pictures;
	}

	@Override
	public List<Advertisement> findLastestAds() throws RealEstateException {
		List<Advertisement> latestAds = advertisementDao.findLastestAds();
		return latestAds;
	}

	@Override
	public List<Advertisement> findBestAds() throws RealEstateException {
		List<Advertisement> bestAds = advertisementDao.findBestAds();
		return bestAds;
	}

	@Override
	public List<Advertisement> findAdvertisements(City city) {
		List<Advertisement> advs = advertisementDao.readAll(city);
		return advs;
	}

	@Override
	public List<Advertisement> findAdvertisementByStatus(AdStatus status) throws RealEstateException {
		List<Advertisement> advs = advertisementDao.readAll(status);
		return advs;
	}

	@Override
	public List<Advertisement> findFavorite(User u) throws RealEstateException {
		Stream<Favoris> favs = u.getFavoris().stream();
		Function<Favoris,Advertisement> function = new Function<Favoris,Advertisement>(){
			@Override
			public Advertisement apply(Favoris t) {
				return t.getAdvertisement();
			}
		};
		List<Advertisement> result = favs.map(function).collect(Collectors.toList());
		return result;
	}

	@Override
	public List<Advertisement> findOwnAds(User u) throws RealEstateException {
		List<Advertisement> advs = advertisementDao.readAllByOwner(u);
		return advs;
	}

	@Override
	public void updateAdvertisement(Advertisement ad) throws RealEstateException {
		advertisementDao.update(ad);
	}

	@Override
	public void deleteAdvertisement(Advertisement ad) throws RealEstateException {
		advertisementDao.delete(ad.getId());
		
	}

}
