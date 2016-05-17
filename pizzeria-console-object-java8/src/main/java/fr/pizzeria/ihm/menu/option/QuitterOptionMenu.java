package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;

public class QuitterOptionMenu extends OptionMenu {

	
	private static final String AJOUTER_PIZZA_LIBELLE_MENU = "Quitter";

	public QuitterOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(AJOUTER_PIZZA_LIBELLE_MENU, pizzaDao, scanner);
		
	}
	
	@Override
	public boolean execute() {
		System.out.println("bye bye");

		return false;
	}

}
