package fr.pizzeria.ihm.menu.option;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoFichierImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class ImporterBddOptionMenu extends OptionMenu {

	private static final String AJOUTER_PIZZA_LIBELLE_MENU = "exporter file to bdd";

	public ImporterBddOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(AJOUTER_PIZZA_LIBELLE_MENU, pizzaDao, scanner);

	}	

	@Override
	public boolean execute() {
		PizzaDaoFichierImpl files = new PizzaDaoFichierImpl();
		List<Pizza> pizzas = new ArrayList<>();
		try {
			pizzas = files.findAllPizzas();
			pizzaDao.saveAllPizza(pizzas, 3);
		} catch (DaoException e) {
			System.err.println("erreur d'importation ");
			e.printStackTrace();
		}
		System.out.println("importation réussie ^^");
		return true;
	}
	
}
