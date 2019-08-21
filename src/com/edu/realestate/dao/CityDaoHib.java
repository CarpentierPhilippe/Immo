package com.edu.realestate.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edu.realestate.model.City;

public class CityDaoHib extends AbstractDaoHib implements CityDao {

	private static final Logger LOGGER = LogManager.getLogger(CityDaoHib.class);
	
	@Override
	public void create(City t) {
		Transaction transaction = null;
        try (
        	Session session = getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
            	LOGGER.error("Impossible de creer City");
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}

	@Override
	public City read(Integer id) {
		Transaction transaction = null;
		City result = null;
        try (
        	Session session = getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            result = session.load(City.class, id);
        } catch (Exception e) {
        	LOGGER.error("Impossible de read City");
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return result;
	}

	@Override
	public List<City> readAll() {
		Transaction transaction = null;
		List<City> result = null;
        try (
        	Session session = getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            result = session.createQuery("from City", City.class).list();
        } catch (Exception e) {
        	LOGGER.error("Impossible de read Cities");
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		return result;
	}

	@Override
	public void update(City t) {
		Transaction transaction = null;
        try (
        	Session session = getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            session.update(t);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
            	LOGGER.error("Impossible d'update City");
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
            	LOGGER.error("Impossible de delete City");
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}

}
