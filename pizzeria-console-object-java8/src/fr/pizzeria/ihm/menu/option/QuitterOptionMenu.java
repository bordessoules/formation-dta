package fr.pizzeria.ihm.menu.option;

public class QuitterOptionMenu extends OptionMenu {

	public QuitterOptionMenu() {
		this.libelle="Quitter ";
	}

	@Override
	public boolean execute() {
		System.out.println("bye bye");

		return false;
	}

}
