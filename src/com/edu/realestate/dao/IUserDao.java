package com.edu.realestate.dao;

import com.edu.realestate.exceptions.AuthenticationException;
import com.edu.realestate.model.User;

public interface IUserDao extends IAbstractDao<User> {

	User read(String username);

	User authenticate(String username, String password) throws AuthenticationException;
}
