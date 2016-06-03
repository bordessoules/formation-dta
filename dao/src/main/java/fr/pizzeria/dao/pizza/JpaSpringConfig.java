package fr.pizzeria.dao.pizza;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JpaSpringConfig {
	
	@Bean
	public EntityManagerFactory entityManager(){
		return Persistence.createEntityManagerFactory("pizzeria-console-object-java8");
		
	}

}
