package com.edu.realestate.mapping;

import java.sql.ResultSet;

import com.edu.realestate.model.Advertiser;
import com.edu.realestate.model.Moderator;
import com.edu.realestate.model.User;

public class UserMapper {

	//D'un resultat vers USER
	public static User resultToUser(ResultSet rs) throws Exception{
		User user = null;
		String ut = rs.getString("user_type");
		switch (ut) {
			case "M": user = new Moderator();break;
			default : user = new Advertiser();break;						
		}
		user.setPassword(rs.getString("password"));
		user.setPassword("password");
		user.setUsername(rs.getString("username"));
		return user;
	}
	
	//D'un user vers "Insert/update"
	public static String userToStatement(User user) throws Exception{
		return null;
	}
}
