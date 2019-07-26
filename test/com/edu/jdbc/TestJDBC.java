package com.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edu.realestate.dao.*;
import com.edu.realestate.model.*;

public class TestJDBC {
	public static void main(String[] args) throws Exception {
		TestJDBC test= new TestJDBC();
		
		test.testSearchCriteria();
		
	}
	
	public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Date d = new Date();
		System.out.println(d);
		
		Class clz = Class.forName("java.util.Date");
		Object o = clz.newInstance();
		System.out.println(o);	
	}
	
	public void testCityDAO() {
		CityDao cityDao = new CityDaoJDBC();
		City c = cityDao.read(1);
		System.out.println(c);
	}
	
	public void testUserDAO() {
		UserDaoJDBC userDao = new UserDaoJDBC();
		User u = userDao.read("jmd@yahoo.fr");
		System.out.println(u);
		
		try {
			User usr = userDao.authenticate("jmd@yahoo.fr", "pomme");
			System.out.println(usr);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testDAOReadAll() {
		CityDao cityDao = new CityDaoJDBC();
		List<City> listc = cityDao.readAll();
		for (int i = 0; i < listc.size() ; i++) {
			System.out.println(listc.get(i));
		}
	}
	
	public void testSearchCriteria() {
		SearchCriteria criteria = new SearchCriteria();
		criteria.setCityId(30480);
		SearchDao sdao = new SearchDaoJDBC();
		List<Advertisement> advs = sdao.search(criteria);
		for (Advertisement a : advs)
			System.out.println(a);
		
	}
}
