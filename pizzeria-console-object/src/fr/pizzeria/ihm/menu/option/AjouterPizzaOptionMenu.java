package fr.pizzeria.ihm.menu.option;

import java.util.InputMismatchException;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {

	private Scanner sc;

	public AjouterPizzaOptionMenu(IPizzaDao pizzaDao, Scanner sc) {
		this.sc = sc;
		this.libelle = "Ajouter pizzas ";
		this.pizzaDao = pizzaDao;
	}

	@Override
	public boolean execute() {
		System.out.println("Ajout d'une nouvelle pizza");
		String code, nom;
		double prix;
		System.out.println("Saisir code pizza : ");
		code = sc.next();
		System.out.println("Saisir nom pizza : ");
		nom = sc.next();
		System.out.println("Saisir prix pizza : ");
		try {
			prix = sc.nextDouble();
			try {
				pizzaDao.saveNewPizza(new Pizza(code, nom, prix));
			} catch (SavePizzaException e) {
				System.err.println("erreur le code " + code + "est deja utilisé");
			}
		} catch (InputMismatchException e) {
			sc.next();
			System.err.println("le prix saisie n'etait au bon format");
		}
		return true;
	}

}
