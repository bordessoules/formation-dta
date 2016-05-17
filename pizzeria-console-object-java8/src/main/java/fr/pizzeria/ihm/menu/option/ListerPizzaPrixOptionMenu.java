package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class ListerPizzaPrixOptionMenu extends OptionMenu {


	private static final String AJOUTER_PIZZA_LIBELLE_MENU = "Lister pizzas la plus chere";

	public ListerPizzaPrixOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(AJOUTER_PIZZA_LIBELLE_MENU, pizzaDao, scanner);
		
	}

	
	@Override
	public boolean execute() {
		List<Pizza> pizzas;
		try {
			pizzas = pizzaDao.findAllPizzas();
			pizzas.stream().collect(
						Collectors.maxBy(Comparator.comparing(Pizza::getPrix))).ifPresent(System.out::println);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return true;
	}

}
