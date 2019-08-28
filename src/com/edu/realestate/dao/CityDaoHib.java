package com.edu.realestate.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.edu.realestate.model.City;

@Repository
public class CityDaoHib extends AbstractDaoHib implements CityDao {

	@Override
	public void create(City t) {
		Session session = getSession();
        session.save(t);
	}

	@Override
	public City read(Integer id) {
		Session session = getSession();
        City result = session.load(City.class, id);
		return result;
	}

	@Override
	public List<City> readAll() {
		Session session = getSession();
		List<City> result = session.createQuery("from City", City.class).list();
		return result;
	}

	@Override
	public void update(City t) {
		Session session = getSession();
            session.update(t);
	}

	@Override
	public void delete(Integer id) {
		Session session = getSession();
            session.delete(this.read(id));
	}

}
