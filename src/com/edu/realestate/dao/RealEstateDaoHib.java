package com.edu.realestate.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.realestate.model.RealEstate;

@Repository
public class RealEstateDaoHib extends AbstractDaoJDBC implements RealEstateDao {

	@Override
	public void create(RealEstate t) {
		// TODO Auto-generated method stub

	}

	@Override
	public RealEstate read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RealEstate> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(RealEstate t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

}
