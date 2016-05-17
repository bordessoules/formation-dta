package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class ListerPizzaByCategorieOptionMenu extends OptionMenu {

	private static final String AJOUTER_PIZZA_LIBELLE_MENU = "Lister pizzas par categorie";

	public ListerPizzaByCategorieOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(AJOUTER_PIZZA_LIBELLE_MENU, pizzaDao, scanner);
		
	}
	@Override
	public boolean execute() {
		List<Pizza> pizzas;
		try {
			pizzas = pizzaDao.findAllPizzas();
			pizzas.stream().sorted(Comparator.comparing(Pizza::getCategorie)).forEachOrdered(t -> System.out.println(t.getCategorie().toString()+" "+t));

		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
