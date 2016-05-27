package fr.pizzeria.admin.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.PizzaServiceJpa;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@Path("/pizzas")
public class PizzaRessources {

	@Inject
	private PizzaServiceJpa service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> list() {
		List<Pizza> pizzas=null;
		try {
			pizzas = service.findAllPizzas();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	return pizzas;

	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Pizza p) {
		try {
			service.saveNewPizza(p);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Pizza p) {
		try {
			service.updatePizza(p.getCode(), p);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@DELETE
	@Path("/{code}")
	public void update(@PathParam("code") String code) {
		try {
			service.deletePizza(code);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
