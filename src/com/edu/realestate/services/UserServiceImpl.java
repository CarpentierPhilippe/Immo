package com.edu.realestate.services;

import com.edu.realestate.dao.UserDao;
import com.edu.realestate.dao.UserDaoJDBC;
import com.edu.realestate.exceptions.AuthenticationException;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.Advertiser;
import com.edu.realestate.model.Moderator;
import com.edu.realestate.model.User;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoJDBC();
	
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

}
