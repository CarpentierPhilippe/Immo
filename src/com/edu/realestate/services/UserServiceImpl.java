package com.edu.realestate.services;

import com.edu.realestate.dao.IUserDao;
import com.edu.realestate.dao.UserDaoJDBC;
import com.edu.realestate.exceptions.AuthenticationException;
import com.edu.realestate.model.Advertiser;
import com.edu.realestate.model.Moderator;
import com.edu.realestate.model.User;

public class UserServiceImpl implements UserService {

	IUserDao userDao;
	@Override
	public void register(Advertiser adv) {
		// TODO Auto-generated method stub
		userDao = new UserDaoJDBC();
	}

	@Override
	public void register(Moderator mod) {
		// TODO Auto-generated method stub

	}

	@Override
	public User authenticate(String login, String password) throws AuthenticationException {
		// TODO Auto-generated method stub
		return userDao.authenticate(login, password);
	}

	@Override
	public void disconnect(User u) {
		// TODO Auto-generated method stub

	}

}