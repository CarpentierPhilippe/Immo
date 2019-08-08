package com.edu.realestate.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edu.realestate.exceptions.AuthenticationException;
import com.edu.realestate.mapping.UserMapper;
import com.edu.realestate.model.Advertisement;
import com.edu.realestate.model.User;

public class UserDaoJDBC extends AbstractDaoJDBC implements UserDao {

	@Override
	public void create(User t) {
		// TODO Auto-generated method stub

	}

	@Override
	public User read(Integer id) {
		throw new UnsupportedOperationException("Not supported.");
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
		try {
			Statement st = getConnection().createStatement();
			String sql = "SELECT * from user_data where username = '"+username+"'";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				user = UserMapper.resultToUser(rs);
			}
		} catch (Exception e) {
		}
		return user;
	}
	
	// RESERVEE A UN USAGE CLIENT 
	@Override
	public User authenticate (String username, String password) throws AuthenticationException {
		User user = null;
		try {
			String sql = 
					"SELECT * from user_data where username = '"+username+"' AND password = '"+password+"'";
			Statement st = getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if (!rs.next()) 
				throw new AuthenticationException();
			
			user = UserMapper.resultToUser(rs);
		} catch (Exception e) {
			throw new AuthenticationException("Pb de Connection");
		}
		return user;
	}

	@Override
	public List<User> readAll() {
		List<User> result = new ArrayList<User>();
		try {
			Statement st = getConnection().createStatement();
			String sql = "SELECT * from user_data";
			ResultSet rs = st.executeQuery(sql);
			
			User user = null;
			while (rs.next()) {
				user = UserMapper.resultToUser(rs);
				result.add(user);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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
