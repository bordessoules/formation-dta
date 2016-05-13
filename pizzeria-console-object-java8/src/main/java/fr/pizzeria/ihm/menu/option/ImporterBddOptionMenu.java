package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class ImporterBddOptionMenu extends OptionMenu {

	private static final String AJOUTER_PIZZA_LIBELLE_MENU = "exporter file to bdd";

	public ImporterBddOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(AJOUTER_PIZZA_LIBELLE_MENU, pizzaDao, scanner);

	}	

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		return false;
	}

}
