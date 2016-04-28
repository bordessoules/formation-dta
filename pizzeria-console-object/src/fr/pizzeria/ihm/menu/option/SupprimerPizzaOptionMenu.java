package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	private Scanner sc;

	public SupprimerPizzaOptionMenu(IPizzaDao pizzaDao, Scanner sc) {
		this.libelle = "Supprimer pizzas ";
		this.pizzaDao = pizzaDao;
		this.sc = sc;

	}

	@Override
	public boolean execute() {
		String code;
		System.out.println("entrer code pizza a supprimer : ");
		code = sc.next();
		try {
			pizzaDao.deletePizza(code);
		} catch (DeletePizzaException e) {
			System.err.println("le code pizza ne corespond pas a une pizza");
		}
		return true;
	}

}
