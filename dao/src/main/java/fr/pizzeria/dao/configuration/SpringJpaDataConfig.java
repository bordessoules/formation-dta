package fr.pizzeria.dao.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.dao.pizza.BatchPizza;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJpaDataSpring;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("fr.pizzeria.repos")
public class SpringJpaDataConfig {
	

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setPersistenceUnitName("pizzeria-console-object-java8");
		return factory;
	}

	@Bean	
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager();
		
		}
	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
		return new PersistenceExceptionTranslationPostProcessor();
	}
	@Bean
	public IPizzaDao pizzaDaoJpaDataSpring(){
		  return new PizzaDaoJpaDataSpring();
	}
	@Bean
	public BatchPizza batchPizza(){
		return new BatchPizza(); 
	}
	
}

