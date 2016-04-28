package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	private List<Pizza> pizzas;
	@Override
	public Pizza[] findAllPizzas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

	public PizzaDaoImpl() {
		super();
		pizzas=new ArrayList<Pizza>();
		pizzas.add(new Pizza( "PEP", "Pépéroni", 12.50)) ;
		pizzas.add(new Pizza(  "MAR", "Margherita", 14.00)) ;
		pizzas.add(new Pizza(  "REI", "La Reine", 11.50 )) ;
		pizzas.add(new Pizza(  "FRO", "La 4 fromages", 12.00 )) ;
		pizzas.add(new Pizza(  "CAN", "La cannibale", 12.50 )) ;
		pizzas.add(new Pizza(  "SAV", "La savoyarde", 13.00 )) ;
		pizzas.add(new Pizza(  "ORI", "L'orientale", 13.50 ) );
		pizzas.add(new Pizza(  "IND", "L'indienne", 14.00 ));
	}

}
