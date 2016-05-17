package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;

public class QuitterOptionMenu extends OptionMenu {

	
	private static final String AJOUTER_PIZZA_LIBELLE_MENU = "Quitter";

	public QuitterOptionMenu( ) {
		super(AJOUTER_PIZZA_LIBELLE_MENU, null, null);
		
	}
	
	@Override
	public boolean execute() {
		System.out.println("bye bye");

		return false;
	}

}
