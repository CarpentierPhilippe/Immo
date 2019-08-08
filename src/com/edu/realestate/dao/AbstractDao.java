package com.edu.realestate.dao;

import java.util.List;

public interface AbstractDao<T> {
	
	void create(T t);
	
	T read(Integer id);
	
	List<T> readAll();

	void update(T t);
	
	void delete(Integer id);
}
