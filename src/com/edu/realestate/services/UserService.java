package com.edu.realestate.services;

import com.edu.realestate.exceptions.AuthenticationException;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.Advertiser;
import com.edu.realestate.model.Moderator;
import com.edu.realestate.model.User;

public interface UserService {


	void register(Advertiser adv);
	
	void register(Moderator mod);
	
	User authenticate(String login, String password)
		throws AuthenticationException ;
	
	void disconnect(User u);
	
	void updateUser(User u);
	
	
	void favAdvertisement(User u, Advertisement adv);

	void deleteUser(String username);

	void unfavAdvertisement(User s, Advertisement adv);
}
