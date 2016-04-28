package fr.pizzeria.ihm.menu;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.ihm.menu.option.OptionMenu;

public class Menu {
	private String title;
	OptionMenu[] actions;
	private Scanner scan;
	public Menu(String title,Scanner scan, OptionMenu... menus) {
		this.title = title;
		this.scan = scan;
		this.actions = menus;
	}

	public void afficher() {
		int choice;
		do {
			System.out.println("****** " + title + " ******");
			for (int i = 0; i < actions.length; i++) {
				System.out.println(i+" "+actions[i].getLibelle());
			}
			System.out.println("faites votre choix");
			choice = this.scan.nextInt();

		} while (actions[choice].execute());
	}
}
