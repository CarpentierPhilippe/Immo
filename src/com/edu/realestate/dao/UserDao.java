package com.edu.realestate.dao;

import com.edu.realestate.exceptions.AuthenticationException;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.User;

public interface UserDao extends AbstractDao<User> {

	public User read(String username);

	public User authenticate(String username, String password) throws AuthenticationException;

	public void disconnect(User u);

	public void delete(String username);

	public void favAdvertisement(User u, Advertisement adv);

	public void unfavAdvertisement(User u, Advertisement adv);
}
