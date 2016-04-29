package fr.pizzeria.ihm.menu;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import fr.pizzeria.ihm.menu.option.OptionMenu;

public class Menu {
	private String title;
	Map<Integer, OptionMenu> actions;
	private Scanner scan;

	public Menu(String title, Scanner scan, OptionMenu... menus) {
		this.title = title;
		this.scan = scan;
		this.actions = new HashMap<Integer, OptionMenu>();
		for (int i = 0; i < menus.length; i++) {
			this.actions.put(i, menus[i]);

		}
	}

	public void afficher() {
		int choice;
		boolean arret = true;
		do {
			System.out.println("****** " + title + " ******");
			for (Integer i : actions.keySet()) {
				System.out.println(i + " " + actions.get(i).getLibelle());
			}
			
			System.out.println("faites votre choix");
			try {
				choice = this.scan.nextInt();
				arret = actions.get(choice).execute();
			} catch (InputMismatchException e) {
				scan.next();
				System.err.println("le prix saisie n'etait au bon format");
			}

		} while (arret);
	}
}
