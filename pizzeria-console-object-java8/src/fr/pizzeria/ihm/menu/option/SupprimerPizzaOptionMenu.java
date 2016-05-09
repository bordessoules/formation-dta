package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DaoException;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	private static final String AJOUTER_PIZZA_LIBELLE_MENU =  "Supprimer pizzas ";

	public SupprimerPizzaOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(AJOUTER_PIZZA_LIBELLE_MENU, pizzaDao, scanner);
		
	}

	@Override
	public boolean execute() {
		String code;
		System.out.println("entrer code pizza a supprimer : ");
		code = sc.next();
		try {
			pizzaDao.deletePizza(code);
		} catch (DaoException e) {
			System.err.println("le code pizza ne corespond pas a une pizza");
		}
		return true;
	}

}
