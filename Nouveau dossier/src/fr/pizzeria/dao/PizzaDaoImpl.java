package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	private Map<String, Pizza> pizzas;

	@Override
	public List<Pizza> findAllPizzas() {

		return new ArrayList<Pizza>(pizzas.values());
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

	public PizzaDaoImpl() {
		super();
		pizzas = new TreeMap<String, Pizza>();
		pizzas.put("PEP", new Pizza("PEP", "Pépéroni", 12.50,CategoriePizza.VIANDE));
		pizzas.put("MAR", new Pizza("MAR", "Margherita", 14.00,CategoriePizza.SANS_VIANDE));
		pizzas.put("REI", new Pizza("REI", "La Reine", 11.50,CategoriePizza.VIANDE));
		pizzas.put("FRO", new Pizza("FRO", "La 4 fromages", 12.00,CategoriePizza.SANS_VIANDE));
		pizzas.put("CAN", new Pizza("CAN", "La cannibale", 12.50,CategoriePizza.VIANDE));
		pizzas.put("SAV", new Pizza("SAV", "La savoyarde", 13.00,CategoriePizza.VIANDE));
		pizzas.put("ORI", new Pizza("ORI", "L'orientale", 13.50,CategoriePizza.VIANDE));
		pizzas.put("IND", new Pizza("IND", "L'indienne", 14.00,CategoriePizza.VIANDE));
	}

}
