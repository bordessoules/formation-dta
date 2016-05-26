package fr.pizzeria.admin.metier;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

@ApplicationScoped
public class PizzaService {
	@Inject
	@Named("pizzaDaoImpl")
	private IPizzaDao dao;

	public List<Pizza> findAllPizzas() throws DaoException {
		// TODO Auto-generated method stub
		return dao.findAllPizzas();
	}

	public void saveNewPizza(Pizza pizza) throws SavePizzaException, DaoException {
		dao.saveNewPizza(pizza);
	}

	public void updatePizza(String codePizza, Pizza pizza)
			throws UpdatePizzaException, DeletePizzaException, SavePizzaException, DaoException {
		dao.updatePizza(codePizza, pizza);
	}

	public void deletePizza(String codePizza) throws DeletePizzaException, DaoException {
		dao.deletePizza(codePizza);
	}

	public void saveAllPizza(List<Pizza> pizzas, int nb) throws DaoException {
		dao.saveAllPizza(pizzas, nb);
	}
}
