package fr.eservices.drive.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;


// use this class as a configuration class for spring context
// set a scan package to get JPA DAO and Hmac password checker
@ComponentScan(basePackages = {"fr.eservices.drive.dao.impl", "fr.eservices.drive.util", "fr.eservices.drive.app"})
@Configuration
public class SpringConfig {

	// expose this as a bean for spring context
	// expose an entity manager for DAO using JPA
	@Bean
	EntityManager entityManager() {
		return entityManager();
	}
	

}
