package com.mic3.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class AppStartup implements ApplicationListener<ContextRefreshedEvent> {
    
	@Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("$$$$$$$$ CONTEXT NAME $$$$$$$$$$ "+ event.getApplicationContext().getDisplayName());
		System.out.println("$$$$$$$$ BEAN COUNT $$$$$$$$$ "+ event.getApplicationContext().getBeanDefinitionCount());
    }
}