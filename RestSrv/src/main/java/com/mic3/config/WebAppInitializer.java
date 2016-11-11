package com.mic3.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {
	
	@Override
	public void onStartup(ServletContext container) throws ServletException {
		
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(WebConfig.class);
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{""}, rootContext);

		// Manage the lifecycle of the root application context
		container.addListener(new ContextLoaderListener(rootContext));
		
		// Create the dispatcher servlet's Spring application context
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = container.addServlet(
			"dispatcher", new DispatcherServlet(dispatcherContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		dispatcher.setAsyncSupported(true);
	}
}

