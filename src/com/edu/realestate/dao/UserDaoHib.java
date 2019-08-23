package com.edu.realestate.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edu.realestate.exceptions.AuthenticationException;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.User;

@Repository
@Transactional
public class UserDaoHib extends AbstractDaoHib implements UserDao{

	@Override
	public void create(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disconnect(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void favAdvertisement(User u, Advertisement adv) {
		// TODO Auto-generated method stub
		
	}

}
