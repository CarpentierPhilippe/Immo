package com.edu.realestate.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.edu.realestate.model.RealEstate;

@Repository
public class RealEstateDaoHib extends AbstractDaoHib implements RealEstateDao {

	@Override
	public void create(RealEstate t) {
		Session session = getSession();
        session.save(t);
	}

	@Override
	public RealEstate read(Integer id) {
		Session session = getSession();
		RealEstate result = session.load(RealEstate.class, id);
		return result;
	}

	@Override
	public List<RealEstate> readAll() {
		Session session = getSession();
		List<RealEstate> result = session.createQuery("from RealEstate", RealEstate.class).list();
		return result;
	}

	@Override
	public void update(RealEstate t) {
		Session session = getSession();
        session.update(t);
	}

	@Override
	public void delete(Integer id) {
		Session session = getSession();
        session.delete(this.read(id));
	}

}
