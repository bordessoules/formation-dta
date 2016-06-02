package fr.pizzeria.console;

import java.util.Scanner;

import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.dao.pizza.PizzaDaoJdbc;
import fr.pizzeria.dao.pizza.PizzaDaoJpa;
import fr.pizzeria.dao.pizza.PizzaDaoSpringJdbc;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
@EnableTransactionManagement
public class PizzeriaAppSpringConfig {

	

	@Bean
	public DataSource dataSource(@Value("${jdbc.driver}") String driver, @Value("${jdbc.url}") String url,
			@Value("${jdbc.user}") String user, @Value("${jdbc.pass}") String pass) {
		return new DriverManagerDataSource(url, user, pass);
	}
	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource ) {
		return new DataSourceTransactionManager(dataSource);

	}
	@Bean
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer prop = new PropertyPlaceholderConfigurer();
		prop.setLocation(new ClassPathResource("jdbc.properties"));
		return prop;
	}

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	@Bean
	public IPizzaDao dao(@Value("${jdbc.driver}") String driver, @Value("${jdbc.url}") String url,
			@Value("${jdbc.user}") String user, @Value("${jdbc.pass}") String pass) {
		/*
		 * IPizzaDao d=null; try { d= new PizzaDaoJdbc(); } catch
		 * (ClassNotFoundException e) { e.printStackTrace(); }
		 * 
		 * return d;
		 */
		
		// return new PizzaDaoImpl();

		// return new PizzaDaoJpa(Persistence.createEntityManagerFactory("pizzeria-console-object-java8"));
		
		return new PizzaDaoSpringJdbc(dataSource(driver, url, user, pass));
	}

}
