package com.edu.realestate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edu.realestate.model.AdStatus;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.City;
import com.edu.realestate.model.User;

@Repository
@Qualifier("hibernate")
@Transactional 
public class AdvertisementDaoHib extends AbstractDaoHib implements AdvertisementDao {
	
	@Override
	public void create(Advertisement t) {
    	Session session = getSession();
        session.save(t);
	}

	@Override
	public Advertisement read(Integer id) {
		Advertisement advertisement = null;
        	Session session = getSession();
            advertisement = session.load(Advertisement.class, id);
		return advertisement;
	}

	@Override
	public List<Advertisement> readAll() {
		List<Advertisement> result = null;
    	Session session = getSession();
        result = session.createQuery("from Advertisement", Advertisement.class).setMaxResults(10).list();
		return result;
	}

	@Override
	public void update(Advertisement t) {
        	Session session = getSession();
            session.saveOrUpdate(t);
	}

	@Override
	public void delete(Integer id) {
		Session session = getSession();
            session.delete(this.read(id));;
	}

	@Override
	public List<Advertisement> findLastestAds() {
		Session session = getSession();
		List<Advertisement> result = session.createQuery("from Advertisement order by releaseDate desc", Advertisement.class).setMaxResults(100).list();
		return result;
	}

	@Override
	public List<Advertisement> findBestAds() {
		Session session = getSession();
		String hql = "select a"
				+ " from Advertisement a"
				+ " inner join Favoris f"
				+ " order by count()";
		Query<Advertisement> query = session.createQuery(hql, Advertisement.class);
		List<Advertisement> result = query.setMaxResults(100).getResultList();
		return result;
	}

	@Override
	public List<Advertisement> readAll(City city) {
		Session session = getSession();
		String hql = "select a from Advertisement a where a.realEstate.city = :city";
		List<Advertisement> result = session.createQuery(hql, Advertisement.class).setParameter("city",city).setMaxResults(100).getResultList();
		return result;
	}

	@Override
	public List<Advertisement> readAll(AdStatus status) {
		Session session = getSession();
		String hql = "select a from Advertisement a where a.status = :status";
		Query<Advertisement> query = session.createQuery(hql, Advertisement.class);
		query.setParameter("status",status);
		
		List<Advertisement> result = query.setMaxResults(100).getResultList();
		return result;
	}

	@Override
	public List<Advertisement> readAllByFav(User u) {
		Session session = getSession();
		String hql = "select a"
				+ " from Advertisement a"
				+ " join Favoris f"
				+ " where f.owner = :user";
		Query<Advertisement> query = session.createQuery(hql, Advertisement.class);
		query.setParameter("user",u);
		List<Advertisement> result = query.setMaxResults(100).getResultList();
		return result;
	}

	@Override
	public List<Advertisement> readAllByOwner(User u) {
		Session session = getSession();
		String hql = "select a from Advertisement a where a.advertiser.username = :userid";
		Query<Advertisement> query = session.createQuery(hql, Advertisement.class);
		query.setParameter("userid", u.getUsername());
		List<Advertisement> result = query.setMaxResults(100).getResultList();
		return result;
	}

	@Override
	public void validateAdvertisement(int adId) {
		Session session = getSession();
		String hql = "update Advertisement a set a.status = :statut where a.id = :adId";
		session.createQuery(hql).setParameter("statut", AdStatus.Validated).setParameter("adId", adId);
	}

	@Override
	public void changeStatusAdv(int adId, AdStatus validated) {
		Session session = getSession();
		String hql = "update Advertisement a set a.status = :statut where a.id = :adId";
		session.createQuery(hql).setParameter("statut", validated).setParameter("adId", adId);
	}

	@Override
	public void changeStatusAdv(int adId, AdStatus refused, String refusedComment) {
		Session session = getSession();
		String hql = "update Advertisement a set a.status = :statut and a.refusedComment = :refusedComment where a.id = :adId";
		session.createQuery(hql).setParameter("statut", refused).setParameter("refusedComment", refusedComment).setParameter("adId", adId);
	}

}
