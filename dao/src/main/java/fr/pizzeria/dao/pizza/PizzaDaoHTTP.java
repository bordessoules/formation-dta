package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoHTTP implements IPizzaDao {

	@Override
	public List<Pizza> findAllPizzas() throws DaoException {

		
		return ClientBuilder.newClient()
	            .target("http://localhost:8080/pizzeria-admin-app")
	            .path("api").path("pizzas")
	            .request().get(new GenericType<List<Pizza>>(){});
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException, DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza)
			throws UpdatePizzaException, DeletePizzaException, SavePizzaException, DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException, DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveAllPizza(List<Pizza> pizzas, int nb) throws DaoException {
		// TODO Auto-generated method stub

	}

}
