package fr.pizzeria.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import fr.pizzeria.dao.pizza.IPizzaDao;

@ContextConfiguration(classes=SpringJpaConfig.class)
public class PizzaDaoJpaTest extends PizzaDaoTest {
	@Autowired
	public void setPizzaDao(@Qualifier("pizzaDaoSpringJpa") IPizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}

}
