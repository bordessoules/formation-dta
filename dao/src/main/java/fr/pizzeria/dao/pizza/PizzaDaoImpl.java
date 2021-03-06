package fr.pizzeria.dao.pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Named;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
@Named
public class PizzaDaoImpl implements IPizzaDao {
	private Map<String, Pizza> pizzas;

	public PizzaDaoImpl() {
		super();
		pizzas = new TreeMap<>();
		pizzas.put("PEP", new Pizza("PEP", "Pépéroni", 12.50,CategoriePizza.VIANDE));
		pizzas.put("MAR", new Pizza("MAR", "Margherita", 14.00,CategoriePizza.SANS_VIANDE));
		pizzas.put("REI", new Pizza("REI", "La Reine", 11.50,CategoriePizza.VIANDE));
		pizzas.put("FRO", new Pizza("FRO", "La 4 fromages", 12.00,CategoriePizza.SANS_VIANDE));
		pizzas.put("CAN", new Pizza("CAN", "La cannibale", 12.50,CategoriePizza.VIANDE));
		pizzas.put("SAV", new Pizza("SAV", "La savoyarde", 13.00,CategoriePizza.VIANDE));
		pizzas.put("ORI", new Pizza("ORI", "L'orientale", 13.50,CategoriePizza.VIANDE));
		pizzas.put("IND", new Pizza("IND", "L'indienne", 14.00,CategoriePizza.VIANDE));
	}

	
	@Override
	public List<Pizza> findAllPizzas() {

		return new ArrayList<>(pizzas.values());
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {
		if (!pizzas.containsKey(pizza.getCode())) {
			pizzas.put(pizza.getCode(), pizza);

		} else {
			throw new SavePizzaException();
		}

	}

	@Override
	public void updatePizza(String codeOldPizza, Pizza pizza)
			throws UpdatePizzaException, DeletePizzaException, SavePizzaException {
		if (pizzas.containsKey(codeOldPizza)) {
			deletePizza(codeOldPizza);
			saveNewPizza(pizza);
		} else {
			throw new UpdatePizzaException();
		}
	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		if (pizzas.containsKey(codePizza)) {
			pizzas.remove(codePizza);

		} else {
			throw new DeletePizzaException();

		}

	}


	@Override
	public void saveAllPizzas(List<Pizza> pizzas, int nb) throws DaoException {
		throw new DaoException("méthode non implémentée");		
	}

	
}
