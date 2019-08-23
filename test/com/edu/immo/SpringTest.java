package com.edu.immo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.edu.realestate.config.MaConfig;
import com.edu.realestate.config.TestConfig;
import com.edu.realestate.dao.SearchDao;

@SuppressWarnings("unused")
public class SpringTest {
	
	public static void main(String[] args) {
		
		//Config depuis une class config
		ApplicationContext springCtx = new AnnotationConfigApplicationContext(TestConfig.class, MaConfig.class);

		
		//--------------
		
		
		Object o = springCtx.getBean("obj");
		System.out.println("obj : " +o);
		
		o = springCtx.getBean("nombre");
		System.out.println("nombre : "+o);
		
		o = springCtx.getBean("unDouble");
		System.out.println("unDouble : "+o);
		
		//affiche le même nombre car le random n'est appelé qu'une fois
		o = springCtx.getBean("unDouble");
		System.out.println("unDouble : "+o);
		
		o = springCtx.getBean("doubleAlwaysRandom");
		System.out.println("doubleAlwaysRandom : "+o);
		
		//affiche a chaque fois un nombre différent car le scope prototype
		o = springCtx.getBean("doubleAlwaysRandom");
		System.out.println("doubleAlwaysRandom : "+o);

		//appel en fonction du retour
		o = springCtx.getBean(String.class);
		System.out.println(String.class +" : "+o);
		
		//!\crash car il y a deux methodes qui renvois un Number
		//o = springCtx.getBean(Number.class);
		//System.out.println(o);
			
		o = springCtx.getBean("cityDao");
		System.out.println("cityDao : "+o);
		
		o = springCtx.getBean(SearchDao.class);
		System.out.println("SearchDao : "+o);
		
		
		((AnnotationConfigApplicationContext)springCtx).close();
	}
}
