package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoHTTP implements IPizzaDao {

	private String token;

	public PizzaDaoHTTP() {
		Invocation.Builder b = ClientBuilder.newClient().target("http://localhost:8080/pizzeria-admin-app").path("api")
				.path("login").request();

		Response post = b.post(Entity.entity("login=admin&mdp=admin123", MediaType.APPLICATION_FORM_URLENCODED));
		token = post.readEntity(String.class);
	}

	@Override
	public List<Pizza> findAllPizzas() throws DaoException {

		return ClientBuilder.newClient().target("http://localhost:8080/pizzeria-admin-app").path("api").path("pizzas")
				.request().header("auth", token).get(new GenericType<List<Pizza>>() {
				});
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException, DaoException {
		ClientBuilder.newClient().target("http://localhost:8080/pizzeria-admin-app").path("api").path("pizzas")
				.request().post(Entity.entity(pizza, MediaType.APPLICATION_JSON));

		// TODO Auto-generated method stub

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza)
			throws UpdatePizzaException, DeletePizzaException, SavePizzaException, DaoException {
		ClientBuilder.newClient().target("http://localhost:8080/pizzeria-admin-app").path("api").path("pizzas")
				.request().put(Entity.entity(pizza, MediaType.APPLICATION_JSON));
	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException, DaoException {
		ClientBuilder.newClient().target("http://localhost:8080/pizzeria-admin-app").path("api").path("pizzas")
				.path(codePizza).request().delete();
	}

	@Override
	public void saveAllPizza(List<Pizza> pizzas, int nb) throws DaoException {
		// TODO Auto-generated method stub

	}

}
