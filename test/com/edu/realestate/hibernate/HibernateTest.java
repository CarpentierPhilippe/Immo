package com.edu.realestate.hibernate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.edu.realestate.config.MaConfig;
import com.edu.realestate.config.ServiceConfig;
import com.edu.realestate.config.TestConfig;
import com.edu.realestate.dao.AbstractDaoHib;
import com.edu.realestate.dao.AdvertisementDao;
import com.edu.realestate.dao.AdvertisementDaoHib;
import com.edu.realestate.dao.CityDao;
import com.edu.realestate.dao.CityDaoHib;
import com.edu.realestate.dao.SearchDao;
import com.edu.realestate.dao.SearchDaoHib;
import com.edu.realestate.dao.UserDao;
import com.edu.realestate.exceptions.AuthenticationException;
import com.edu.realestate.exceptions.RealEstateException;
import com.edu.realestate.model.*;
import com.edu.realestate.services.AdvertisementService;
import com.edu.realestate.services.ReferenceService;
import com.edu.realestate.services.ReferenceServiceImpl;
import com.edu.realestate.services.UserService;

@SuppressWarnings("unused")
public class HibernateTest {
		
	private static final Logger LOGGER = LogManager.getLogger(HibernateTest.class);

	public static void main(String[] args) {
		//Config depuis une class config
		ApplicationContext springCtx = new AnnotationConfigApplicationContext(TestConfig.class);
		
		HibernateTest hibTest = new HibernateTest();
		try {
			hibTest.userServiceTest(springCtx);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void referenceServiceTest(ApplicationContext springCtx) throws Exception {
		ReferenceService service = springCtx.getBean(ReferenceService.class);
		
		SearchCriteria crit = new SearchCriteria();
		crit.setQuery("Achat");
		crit.setCityId(1370);
		crit.setAreaMax(50);
		crit.setAreaMin(30);
		crit.setDistance(30);
		
		/*
		service.findAdsByCriteria(criteria);
		*/
		/* TODO
		service.findCitiesByName(input);
		service.listCities();
		service.register(city);
		service.delete(city);
		*/
	}

	public void userServiceTest(ApplicationContext springCtx) throws RealEstateException, AuthenticationException {
		UserService service = springCtx.getBean(UserService.class);
		AdvertisementService advService = springCtx.getBean(AdvertisementService.class);
		
		User user = service.authenticate("jmd@yahoo.fr", "pomme");
		LOGGER.info("User Authenticate : "+user);
		
		Advertiser advertiser = new Advertiser();
		advertiser.setUsername("toSupp@gmail.com");
		advertiser.setPassword("test");
		/*
		service.register(advertiser);
		LOGGER.info("User Created : "+advertiser);
		*/
		/*
		service.deleteUser(advertiser.getUsername());
		LOGGER.info("User deleted : "+advertiser);
		*/
		/*/!\NOT TESTED
		 * TODO
		service.disconnect(user);
		*/
		
		Advertisement adv = advService.findAdvertisementById(2);
		/*
		service.favAdvertisement(user, adv);
		LOGGER.info("fav created : "+advertiser);
		*/
		/*
		service.unfavAdvertisement(user, adv);
		LOGGER.info("unfaved");
		*/
		/*
		Moderator mod = new Moderator();
		mod.setUsername("moderator@realEstate.com");
		mod.setPassword("re");
		service.register(mod);
		LOGGER.info("new mod : "+mod);
		*/
		/*
		((Advertiser) user).setPhone("0655443321");
		service.updateUser(user);
		LOGGER.info("Updated user : "+user);
		*/
		
	}

	public void AdvertisementServiceTest(ApplicationContext springCtx) throws RealEstateException {
		AdvertisementService service = springCtx.getBean(AdvertisementService.class);
		
		Advertisement adv = new Advertisement();
		Advertisement adv2 = new Advertisement();
		
		/*
		adv = service.findAdvertisementById(4);
		LOGGER.info("adv de base : "+adv);
		adv2 = adv;
		/*
		adv2.setTitle("Titre Changé");
		service.updateAdvertisement(adv2);
		LOGGER.info("adv changé: "+service.findAdvertisementById(4));
		adv2.setTitle("Vente Local commercial 62  m², Paris 17 ème (75017)");
		service.updateAdvertisement(adv2);
		LOGGER.info("adv changé: "+service.findAdvertisementById(4));
		*/
		/*  /!\ A voir comment ça insère
		adv2.setId(6472); //utilse que pour supprimer l'adv		
		service.placeAdvertisement(adv2);  
		LOGGER.info("adv inséré: "+service.findAdvertisementById(6472));
		service.deleteAdvertisement(adv2);
		LOGGER.info("adv supprimé");
		*/

		/*
		List<Advertisement> advs = service.findLastestAds();
		for ( Advertisement a : advs)
			LOGGER.info(a);
		*/
		/*
		UserDao userDao = springCtx.getBean(UserDao.class);
		User u = userDao.read("jmd@yahoo.fr");
		LOGGER.info("User : "+u);
		List<Advertisement> advs = service.findOwnAds(u);
		for ( Advertisement a : advs)
			LOGGER.info(a);
		*/
		/*
		CityDao citydao = springCtx.getBean(CityDao.class);
		List<Advertisement> advs = service.findAdvertisements(citydao.read(1370));
		for ( Advertisement a : advs)
			LOGGER.info(a);
		*/
		/*
		List<Advertisement> advs = service.findAdvertisementByStatus(AdStatus.Pending);
		for ( Advertisement a : advs)
			LOGGER.info(a);
		*/
		/*
		UserDao userDao = springCtx.getBean(UserDao.class);
		User u = userDao.read("jmd@yahoo.fr");
		LOGGER.info("User : "+u);
		LOGGER.info(u.getFavoris());
		List<Advertisement> advs = service.findFavorite(u);
		for ( Advertisement a : advs)
			LOGGER.info(a);
		*/
		/*
		List<Advertisement> advs = service.findBestAds();
		for ( Advertisement a : advs)
			LOGGER.info(a);
		*/
		/*
		List<Picture> pictures = service.findPictureByAdId(3);
		for ( Picture picture : pictures)
			LOGGER.info(picture);
		*/
	}
	
	
	/*
	public void testHouseRE() {
		LOGGER.info("start");
		House h = new House();
		h.setAlarm(true);
		h.setAvailable(true);
		RealEstate re = h;
		re.setArea(99);
		re.setId(46);
		re.setPrice(99);
		CityDao citydao = new CityDaoHib();
		re.setCity(citydao.read(1370));
		
		Transaction transaction = null;
        try (
        	Session session = AbstractDaoHib.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            session.save(re);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
            	LOGGER.error("Impossible de creer");
            }
            e.printStackTrace();
        }
        LOGGER.info("cree");
	}
*/
/*
	public void searchAround(SearchCriteria criteria) {
		
		List<Integer> cityIds = null;
		
		if (criteria.getDistance()>0 && criteria.getCityId()>0 ) {
			try(Session session = AbstractDaoHib.getSessionFactory().openSession()) {
				
				CityDao cityDao = new CityDaoHib();
				City cityCentrale = cityDao.read(criteria.getCityId());
				ReturningWork<List<Integer>> rw = new ReturningWork<List<Integer>>() {
					@Override
					public List<Integer> execute(Connection connection) throws SQLException {
						try (CallableStatement function = connection.prepareCall(
								"SELECT id from CITY c where distKM (?,?, c.latitude, c.longitude) < ?")
						){
							function.setDouble(1, cityCentrale.getLatitude());
							function.setDouble(2, cityCentrale.getLongitude());
							function.setDouble(3, Math.min(50,criteria.getDistance()));
							
							function.execute();
							ArrayList<Integer> ids = new  ArrayList<>();
					        ResultSet rs = function.getResultSet();
					        while (rs.next()) 
					        	ids.add(rs.getInt("id"));
					        return ids;
					        
						}catch(Exception e){
							LOGGER.error(e);
						};
						return null;
					}
				};
				cityIds = session.doReturningWork(rw);
				//Ajouter les ID a la requete HQL
			}catch(Exception e){
				LOGGER.error(e);
			};
		}
		for (Integer i : cityIds)
			LOGGER.info(i);
		
	}
*/
	/*
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
*/
	/*
	public void searchCriteriaComplete(SearchCriteria criteria) {
		Transaction transaction = null;
		List<Advertisement> results = null;
        try (
        	Session session = AbstractDaoHib.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            List<Integer> cityIds = new ArrayList<Integer>();
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
            if (criteria.getDistance()>0 && criteria.getCityId()>0 ) {
    				CityDao cityDao = new CityDaoHib();
    				City cityCentrale = cityDao.read(criteria.getCityId());
    				ReturningWork<List<Integer>> rw = new ReturningWork<List<Integer>>() {
    					@Override
    					public List<Integer> execute(Connection connection) throws SQLException {
    						try (CallableStatement function = connection.prepareCall(
    								"SELECT id from CITY c where distKM (?,?, c.latitude, c.longitude) < ?")
    						){
    							function.setDouble(1, cityCentrale.getLatitude());
    							function.setDouble(2, cityCentrale.getLongitude());
    							function.setDouble(3, Math.min(50,criteria.getDistance()));
    							
    							function.execute();
    							ArrayList<Integer> ids = new  ArrayList<>();
    					        ResultSet rs = function.getResultSet();
    					        while (rs.next()) 
    					        	ids.add(rs.getInt("id"));
    					        return ids;
    					        
    						}catch(Exception e){
    							LOGGER.error(e);
    						};
    						return null;
    					}
    				};
    				cityIds = session.doReturningWork(rw);
    				hql += " AND adv.realEstate.city.id in (:ids)";
    		}
            if (criteria.getDistance()>0 && criteria.getCityId()>0) {
            	results = session.createQuery(hql, Advertisement.class).setParameterList("ids", cityIds).setMaxResults(100).list();
            }else {
            	results = session.createQuery(hql, Advertisement.class).setMaxResults(100).list();
            }
        } catch (Exception e) {
            if (transaction != null) {
            }
            e.printStackTrace();
        }
		for (Advertisement result : results)
			LOGGER.info(result);
	}
*/	
	public void searchDaoTest(ApplicationContext springCtx, SearchCriteria criteria) throws RealEstateException {
		List<Advertisement> results = new ArrayList<Advertisement>();
		ReferenceService service = springCtx.getBean(ReferenceService.class);
		results = service.findAdsByCriteria(criteria);
		for (Advertisement result : results)
			LOGGER.info(result);

	}
/*
	@SuppressWarnings("unchecked")	public void incompletSearch() {
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
*/
	/*
	public void testAdvertisementDao() {
		AdvertisementDao dao = new AdvertisementDaoHib();
		ArrayList<Advertisement> listResults = new ArrayList<Advertisement>();
		//LOGGER.info(dao.read(2));
		/*
		ArrayList<Advertisement> listResults = (ArrayList<Advertisement>) dao.readAll();
		LOGGER.info(listResults);
		for (Advertisement result : listResults)
			LOGGER.info(result);
		
		listResults = (ArrayList<Advertisement>) dao.findLastestAds();
		for (Advertisement result : listResults) {
			LOGGER.info(result);
		}
	}
*/
	/*
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
	*/
/*
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
*/
}
