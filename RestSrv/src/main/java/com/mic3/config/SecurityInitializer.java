package com.mic3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityInitializer extends WebSecurityConfigurerAdapter {
	
	@Value("${admin}")
    private String admin;

    @Value("${adminPass}")
    private String adminPass;

    @Value("${roleAdmin}")
    private String roleAdmin;

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
			.withUser(admin).password(generateCryptoPassword(adminPass)).roles(roleAdmin);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	    http
	    .authorizeRequests()
	    .antMatchers(HttpMethod.GET, "/cities").authenticated();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
    }
    
    public static String generateCryptoPassword(String password) {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String hashedPassword = passwordEncoder.encode(password);
    	return hashedPassword;
    }
}
