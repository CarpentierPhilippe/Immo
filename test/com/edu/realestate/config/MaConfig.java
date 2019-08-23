package com.edu.realestate.config;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.edu.realestate.dao.CityDao;
import com.edu.realestate.dao.CityDaoHib;


public class MaConfig {

	//peut-être appelé par le nom de la classe
	@Bean
	public Number nombre() {
		return new Integer(17);
	}
	
	// peut etre seulement appelé par le name
	@Bean(name="unDouble")
	public Number nombre2() {
		Random rand = new Random();
		return new Double(rand.nextInt(50));
	}
	
	@Bean(name="doubleAlwaysRandom")
	@Scope("prototype")
	public Number nombre3() {
		Random rand = new Random();
		return new Double(rand.nextInt(50));
	}
	
	@Bean
	public String obj() {
		return "Hello";
	}
	
	@Bean(name="cityDao")
	@Scope("prototype")
	public CityDao cityDaoxxx() {
		return new CityDaoHib();
	}
	
//	@Bean
//	public SearchDao searchDaoxxx() {
//		return new SearchDaoHib();
//	}
	
}
