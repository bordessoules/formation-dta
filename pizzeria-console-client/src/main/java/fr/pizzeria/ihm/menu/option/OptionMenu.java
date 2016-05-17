package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IDaoFactory;

public abstract class OptionMenu {
	protected String libelle;
	protected IDaoFactory fact;
	protected Scanner sc;

	public OptionMenu(String ajouterLibelleMenu, IDaoFactory fact, Scanner scanner) {
		this.libelle = ajouterLibelleMenu;
		this.fact = fact;
		this.sc = scanner;
	}

	public String getLibelle() {
		return libelle;
	}

	public abstract boolean execute();

}

