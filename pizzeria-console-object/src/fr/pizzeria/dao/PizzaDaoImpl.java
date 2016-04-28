package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	private List<Pizza> pizzas;

	@Override
	public List<Pizza> findAllPizzas() {

		return new ArrayList<Pizza>(pizzas);
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {

		return pizzas.add(pizza);
	}

	public boolean doesPizzaExist(String codePizza) {
		for (Pizza p : pizzas) {
			if (p.getCode().equals(codePizza)) {
				return true;
			}

		}
		return false;

	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		if (doesPizzaExist(codePizza)) {
			deletePizza(codePizza);
			saveNewPizza(pizza);
		} else {
			System.out.println("code invalide");
		}
		return true;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		if (doesPizzaExist(codePizza)){
				for (int i = 0; i < pizzas.size(); i++) {
					
					if (pizzas.get(i).getCode().equals(codePizza) ){
						pizzas.remove(i);
					}
				}
		}
		else {
			System.out.println("code invalide");
		}
		return true;
	
		
	}

	public PizzaDaoImpl() {
		super();
		pizzas = new ArrayList<Pizza>();
		pizzas.add(new Pizza("PEP", "Pépéroni", 12.50));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00));
		pizzas.add(new Pizza("REI", "La Reine", 11.50));
		pizzas.add(new Pizza("FRO", "La 4 fromages", 12.00));
		pizzas.add(new Pizza("CAN", "La cannibale", 12.50));
		pizzas.add(new Pizza("SAV", "La savoyarde", 13.00));
		pizzas.add(new Pizza("ORI", "L'orientale", 13.50));
		pizzas.add(new Pizza("IND", "L'indienne", 14.00));
	}

}
