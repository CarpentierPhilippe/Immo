package com.edu.realestate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDaoHib {
	
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
    	Session session = sessionFactory.getCurrentSession();
    	return session;
    }
}