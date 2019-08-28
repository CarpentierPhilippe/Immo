package com.edu.realestate.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.realestate.dao.UserDao;
import com.edu.realestate.exceptions.AuthenticationException;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.Advertiser;
import com.edu.realestate.model.Moderator;
import com.edu.realestate.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public void register(Advertiser adv) {
		userDao.create(adv);
	}

	@Override
	public void register(Moderator mod) {
		userDao.create(mod);
	}

	@Override
	public User authenticate(String login, String password) throws AuthenticationException {
		System.out.println("userDao");
		return userDao.authenticate(login, password);

	}

	@Override
	public void disconnect(User u) {
		userDao.disconnect(u);
	}

	@Override
	public void updateUser(User u) {
		userDao.update(u);
		
	}

	@Override
	public void deleteUser(String username) {
		userDao.delete(username);
		
	}

	@Override
	public void favAdvertisement(User u, Advertisement adv) {
		userDao.favAdvertisement(u, adv);
		
	}
	
	@Override
	public void unfavAdvertisement(User u, Advertisement adv) {
		userDao.unfavAdvertisement(u, adv);
		
	}

}
