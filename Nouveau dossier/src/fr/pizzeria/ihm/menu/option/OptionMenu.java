package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.dao.IPizzaDao;

public abstract class OptionMenu {
	protected String libelle;
	protected IPizzaDao pizzaDao;

	public String getLibelle() {
		return libelle;
	}

	public abstract boolean execute();

}
