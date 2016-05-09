package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public abstract class OptionMenu {
	protected String libelle;
	protected IPizzaDao pizzaDao;
	protected Scanner sc;

	public OptionMenu(String ajouterPizzaLibelleMenu, IPizzaDao pizzaDao2, Scanner scanner) {
		this.libelle = ajouterPizzaLibelleMenu;
		this.pizzaDao = pizzaDao2;
		this.sc = scanner;
	}

	public String getLibelle() {
		return libelle;
	}

	public abstract boolean execute();

}
