package fr.pizzeria.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.pizza.PizzaDaoSpringJdbc;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzaDaoSpringTest.class)
public class PizzaDaoSpringJdbcTest {
	@Autowired
	private PizzaDaoSpringJdbc pizzaDaoSpringJdbc;
	

	@Test
	public void testfindAllPizza() throws DaoException {
		List<Pizza> pizzas = pizzaDaoSpringJdbc.findAllPizzas();
		Assert.assertEquals(7, pizzas.size());
	}

	

	


	@Test
	public void testsaveAllPizza() throws DaoException {

	}
}
