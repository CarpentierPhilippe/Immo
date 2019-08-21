package com.edu.realestate.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edu.realestate.dao.AbstractDaoHib;
import com.edu.realestate.dao.AdvertisementDao;
import com.edu.realestate.dao.AdvertisementDaoHib;
import com.edu.realestate.dao.CityDao;
import com.edu.realestate.dao.CityDaoHib;
import com.edu.realestate.model.*;

public class HibernateTest {
		
	private static final Logger LOGGER = LogManager.getLogger(HibernateTest.class);

	public static void main(String[] args) {
		HibernateTest hibTest = new HibernateTest();
		SearchCriteria crit = new SearchCriteria();
		crit.setQuery("Achat");
		crit.setCityId(1370);
		crit.setAreaMax(80);
		crit.setAreaMin(50);
		hibTest.searchCriteria(crit);
	}
	
	public void searchCriteria(SearchCriteria criteria) {
		Transaction transaction = null;
		List<Advertisement> results = null;
        try (
        	Session session = AbstractDaoHib.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            String hql = "from Advertisement adv where adv.id>0";
            if (criteria.getCityId() != 0)
            	hql += " AND adv.realEstate.city.id = " + criteria.getCityId();
            if (criteria.getAreaMax() > 0)
            	hql += " AND adv.realEstate.area <" + criteria.getAreaMax();
            if (criteria.getAreaMin() < 99999)
            	hql += " AND adv.realEstate.area >" + criteria.getAreaMin();
            if (criteria.getPriceMax() > 0)
            	hql += " AND adv.realEstate.price <" + criteria.getPriceMax();
            if (criteria.getPriceMin() < 99999)
            	hql += " AND adv.realEstate.price >" + criteria.getPriceMin();
            if (criteria.getQuery() != null && !criteria.getQuery().isEmpty())
            	hql += " AND (adv.description like '%"+criteria.getQuery()+"%' OR adv.title like '%"+criteria.getQuery()+"%')";
            
            results = session.createQuery(hql, Advertisement.class).setMaxResults(100).list();
        } catch (Exception e) {
            if (transaction != null) {
            }
            e.printStackTrace();
        }
		for (Advertisement result : results)
			LOGGER.info(result);
	}
	
	@SuppressWarnings("unchecked")
	public void incompletSearch() {
		Transaction transaction = null;
		List<String> results = null;
        try (
        	Session session = AbstractDaoHib.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            String hql = "select name from City where name like 'Bord%'";
            results = session.createQuery(hql).list();
        } catch (Exception e) {
            if (transaction != null) {
            }
            e.printStackTrace();
        }
		for (String result : results)
			LOGGER.info(result);
	}

	public void testAdvertisementDao() {
		AdvertisementDao dao = new AdvertisementDaoHib();
		ArrayList<Advertisement> listResults = new ArrayList<Advertisement>();
		//LOGGER.info(dao.read(2));
		/*
		ArrayList<Advertisement> listResults = (ArrayList<Advertisement>) dao.readAll();
		LOGGER.info(listResults);
		for (Advertisement result : listResults)
			LOGGER.info(result);
		*/
		listResults = (ArrayList<Advertisement>) dao.findLastestAds();
		for (Advertisement result : listResults) {
			LOGGER.info(result);
		}
	}

	public void testCityDao() {
		CityDao cityDao = new CityDaoHib();
		
		LOGGER.info(cityDao.read(1337));
		
		ArrayList<City> cities = (ArrayList<City>) cityDao.readAll();
		for (City city : cities)
			LOGGER.info(city);
		
		
		City city = new City();
		city.setId(99999);
		city.setName("PlopiluVille");
		city.setPostcode("99999");
		
		cityDao.create(city);
		
		city.setName("SalutSalutVille");
		cityDao.update(city);
		
		cityDao.delete(99999);
		
		
	}


	public void testInitial() {
	
        Transaction transaction = null;
        try (Session session = AbstractDaoHib.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            
            
//            City c1 = session.load(City.class, 1370);
//            System.out.println(c1);
//            
//            Picture pic = session.load(Picture.class, 1);
//            System.out.println(pic);
            
            
            Advertiser advertiser = session.load(Advertiser.class, "jmd@yahoo.fr");
            LOGGER.log(Level.INFO, advertiser);
            
//            Advertisement adv = session.load(Advertisement.class, 48);
//            System.out.println(adv);
//            
////            adv = session.load(Advertisement.class, 47);
////            System.out.println(adv);
////            
////            adv = session.load(Advertisement.class, 48);
////            System.out.println(adv);
//            
//            adv = session.load(Advertisement.class, 52);
//            System.out.println(adv);
            
//            Land h = session.load(Land.class, 639 );
//            System.out.println(h);
            
//            adv = session.load(Advertisement.class, 689);
//            System.out.println(adv);
//            
//            adv = session.load(Advertisement.class, 193);
//            System.out.println(adv);

            
            
        } catch (Exception e) {
            if (transaction != null) {
                //transaction.rollback();
            }
            e.printStackTrace();
        }
	}

}
