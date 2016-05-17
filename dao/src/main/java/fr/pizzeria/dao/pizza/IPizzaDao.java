package fr.pizzeria.dao.pizza;

import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	List<Pizza> findAllPizzas() throws DaoException ;

	void saveNewPizza(Pizza pizza) throws SavePizzaException, DaoException;

	void updatePizza(String codePizza, Pizza pizza)
			throws UpdatePizzaException, DeletePizzaException, SavePizzaException, DaoException;

	void deletePizza(String codePizza) throws DeletePizzaException, DaoException;
	
	public void saveAllPizza(List<Pizza> pizzas, int nb )throws DaoException;
	
}
