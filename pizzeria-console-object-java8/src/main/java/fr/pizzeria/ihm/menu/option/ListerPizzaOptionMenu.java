package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;


public class ListerPizzaOptionMenu extends OptionMenu {
	
	private static final String AJOUTER_PIZZA_LIBELLE_MENU = "Lister pizzas";

	public ListerPizzaOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(AJOUTER_PIZZA_LIBELLE_MENU, pizzaDao, scanner);
		
	}



	@Override
	public boolean execute() {

		List<Pizza> pizzas;
		
		try {
			pizzas = pizzaDao.findAllPizzas();
			pizzas.stream().sorted(Comparator.comparing(Pizza::getCode)).forEach(System.out::println);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("***** "+Pizza.getNbPizza()+" ******");
		return true;
	}

}
