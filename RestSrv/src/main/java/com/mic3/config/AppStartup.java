package com.mic3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mic3.repo.CitiesRepository;
import com.mic3.services.DatabaseService;

@Component
public class AppStartup implements ApplicationListener<ContextRefreshedEvent> {
    
	private DatabaseService dbService;
	
	@Autowired
	public AppStartup(DatabaseService dbService){
		this.dbService = dbService;
	}
	
	@Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("$$$$$$$$ CONTEXT NAME $$$$$$$$$$ "+ event.getApplicationContext().getDisplayName());
		System.out.println("$$$$$$$$ BEAN COUNT $$$$$$$$$ "+ event.getApplicationContext().getBeanDefinitionCount());
//		System.out.println("$$$$$$$$ STARTUP DATE $$$$$$$$$ "+ event.getApplicationContext().getStartupDate());
//		System.out.println("$$$$$$$$ IS BEAN SINGLETON $$$$$$$$$ "+ event.getApplicationContext().isSingleton("databaseService"));
//		System.out.println("$$$$$$$$ IS BEAN PROTOTYPE $$$$$$$$$ "+ event.getApplicationContext().isPrototype("databaseService"));
//		System.out.println("$$$$$$$$ IS BEAN SINGLETON $$$$$$$$$ "+ event.getApplicationContext().isSingleton("databaseService"));
//		System.out.println("$$$$$$$$ IS BEAN SINGLETON $$$$$$$$$ "+ event.getApplicationContext().isPrototype("citiesRepositoryImpl"));
//		System.out.println("$$$$$$$$ IS BEAN PROTOTYPE $$$$$$$$$ "+ event.getApplicationContext().isPrototype("citiesRepositoryImpl"));
//		System.out.println("$$$$$$$$ IS BEAN SINGLETON $$$$$$$$$ "+ event.getApplicationContext().isPrototype("cityService"));

		if(!event.getApplicationContext().getDisplayName().equalsIgnoreCase("Root WebApplicationContext"))
			this.dbService.initializeCityRepo();
    }
}