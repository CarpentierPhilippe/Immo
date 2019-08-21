package com.edu.realestate.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edu.realestate.model.AdStatus;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.City;
import com.edu.realestate.model.User;

public class AdvertisementDaoHib extends AbstractDaoHib implements AdvertisementDao {
	
	private static final Logger LOGGER = LogManager.getLogger(AdvertisementDaoHib.class);

	@Override
	public void create(Advertisement t) {
		Transaction transaction = null;
        try (
        	Session session = getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
            	LOGGER.error("Impossible de creer Advertisement");
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}

	@Override
	public Advertisement read(Integer id) {
		Transaction transaction = null;
		Advertisement advertisement = null;
        try (
        	Session session = getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            advertisement = session.load(Advertisement.class, id);
        } catch (Exception e) {
        	LOGGER.error("Impossible de read Advertisement");
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return advertisement;
	}

	@Override
	public List<Advertisement> readAll() {
		Transaction transaction = null;
		List<Advertisement> result = null;
        try (
        	Session session = getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            result = session.createQuery("from Advertisement", Advertisement.class).setMaxResults(10).list();
        } catch (Exception e) {
        	LOGGER.error("Impossible de read Advertisements");
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return result;
	}

	@Override
	public void update(Advertisement t) {
		Transaction transaction = null;
        try (
        	Session session = getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
            	LOGGER.error("Impossible d'update Advertisement");
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}

	@Override
	public void delete(Integer id) {
		Transaction transaction = null;
        try (
        	Session session = getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            session.delete(this.read(id));;
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
            	LOGGER.error("Impossible de delete Advertisement");
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}

	@Override
	public List<Advertisement> findLastestAds() {
		Transaction transaction = null;
		List<Advertisement> result = null;
        try (
        	Session session = getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            result = session.createQuery("from Advertisement order by releaseDate", Advertisement.class).setMaxResults(10).list();
        } catch (Exception e) {
        	LOGGER.error("Impossible de read Advertisements");
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return result;
	}

	@Override
	public List<Advertisement> findBestAds() {
        //TODO
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
