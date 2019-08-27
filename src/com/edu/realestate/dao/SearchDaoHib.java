package com.edu.realestate.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.City;
import com.edu.realestate.model.SearchCriteria;

@Repository
@Transactional
public class SearchDaoHib extends AbstractDaoHib implements SearchDao {

	private static final Logger LOGGER = LogManager.getLogger(SearchDaoHib.class);
	
	@Autowired
	CityDao cityDao;
	
	@Override
	public List<Advertisement> search(SearchCriteria criteria) {
		List<Advertisement> results = null;
        Session session = getSession();
        // start a transaction
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
		return results;
	}

	@Override
	public List<City> search(String cityName) {
		List<City> result = null;
    	Session session = getSession();
        result = session.createQuery("from City c where c.name = :cityName", City.class).setParameter("cityName", cityName).list();
		return result;
	}

	@Override
	public List<City> search() {
		List<City> result = null;
    	Session session = getSession();
        result = session.createQuery("from City", City.class).list();
		return result;
	}
}
