package fr.pizzeria.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import fr.pizzeria.dao.pizza.IPizzaDao;

@Configuration
public class PizzaDaoSpringTest {
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("db-schema.sql")
				.addScript("db-data.sql").build();
	}

	@Bean
	public IPizzaDao pizzaDao(DataSource ds) {
		return new fr.pizzeria.dao.pizza.PizzaDaoSpringJdbc(ds);
	}
	/*
	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);

	}
/*
	@Bean
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer prop = new PropertyPlaceholderConfigurer();
		prop.setLocation(new ClassPathResource("jdbc.properties"));
		return prop;
	}*/
}
