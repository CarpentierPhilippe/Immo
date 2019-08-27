package com.edu.realestate.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edu.realestate.exceptions.AuthenticationException;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.Favoris;
import com.edu.realestate.model.User;

@Repository
@Transactional
public class UserDaoHib extends AbstractDaoHib implements UserDao{

	@Override
	public void create(User t) {
    	Session session = getSession();
        session.save(t);
	}

	@Override
	public User read(Integer id) {
		throw new UnsupportedOperationException("Don't use read(Integer), use read(String)");
	}

	@Override
	public List<User> readAll() {
		List<User> result = null;
    	Session session = getSession();
        result = session.createQuery("from User", User.class).setMaxResults(25).list();
		return result;
	}

	@Override
	public void update(User t) {
    	Session session = getSession();
        session.update(t);
	}

	@Override
	public void delete(Integer id) {
		throw new UnsupportedOperationException("Don't use delete(Integer), use delete(String)");
	}

	@Override
	public User read(String username) {
		User user = null;
    	Session session = getSession();
    	user = session.load(User.class, username);
        return user;
	}

	@Override
	public User authenticate(String username, String password) throws AuthenticationException {
		List<User> result = null;
    	Session session = getSession();
    	String hql = "from User u where u.username = :username and u.password = :password";
    	result = session.createQuery(hql, User.class).setParameter("username", username).setParameter("password", password).list();
        if (result !=null && result.size() == 1) {
        	return result.get(0);
        }else {
    	throw new AuthenticationException("Mot de passe ou nom d'utilisateur incorrect");
        }
	}

	@Override
	public void disconnect(User u) {
		//TODO
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(String username) {
		Session session = getSession();
        session.delete(this.read(username));
	}

	@Override
	public void favAdvertisement(User u, Advertisement adv) {
		Session session = getSession();
		Favoris fav = new Favoris();
		fav.setOwner(u);
		fav.setAdvertisement(adv);
		session.save(fav);
	}

	@Override
	public void unfavAdvertisement(User u, Advertisement adv) {
		Session session = getSession();
		Favoris fav = session.createQuery("from Favoris f where f.owner = :u and f.advertisement = :adv", Favoris.class).setParameter("u", u).setParameter("adv", adv).getSingleResult();
		session.delete(fav);
	}

}
