package com.mic3.config;

import java.util.List;
import java.util.concurrent.Executors;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;

import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.mic3.interceptors.CallableRequestInterceptor;
import com.mic3.interceptors.RequestInterceptor;


@Configuration
@EnableWebMvc
@EnableAsync
@EnableCaching
@ComponentScan(basePackages="com.mic3")
public class WebConfig extends WebMvcConfigurerAdapter {

	// configure view resolver
//	@Bean
//	public ViewResolver viewResolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/WEB-INF/views/");
//		resolver.setSuffix(".jsp");
//		resolver.setViewClass(
//				org.springframework.web.servlet.view.JstlView.class);
//		resolver.setExposeContextBeansAsAttributes(true);
//		return resolver;
//	}
	
	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		return cmfb;
	}
	
	//static content handling
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		super.configureAsyncSupport(configurer);
		configurer.registerCallableInterceptors(new CallableRequestInterceptor());
		configurer.setTaskExecutor(new ConcurrentTaskExecutor(Executors.newCachedThreadPool()));
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(new RequestInterceptor());
	}
	
	
	@Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		converters.add(new MappingJackson2HttpMessageConverter());
    }
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();
		properties.setLocation(new ClassPathResource("config.properties"));
		return properties;
    }
}
