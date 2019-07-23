package com.edu.realestate.dao;

import java.util.List;

import com.edu.realestate.model.City;

public interface IAbstractDao<T> {
	
	void create(T t);
	
	T read(Integer id);
	
	List<T> readAll();

	void update(T t);
	
	void delete(Integer id);
}
