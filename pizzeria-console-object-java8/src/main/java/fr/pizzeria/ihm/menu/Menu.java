package fr.pizzeria.ihm.menu;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.ihm.menu.option.OptionMenu;

@Component
public class Menu {
	private String title;
	Map<Integer, OptionMenu> actions = new TreeMap<>();
	private Scanner scan;
	private IPizzaDao dao;

	@Autowired
	public Menu(Scanner scan, IPizzaDao dao) {
		super();
		this.title = "pizzeria administration";
		this.scan = scan;
		this.dao = dao;

	}

	public Menu(OptionMenu menuExit, String title, Scanner scan, OptionMenu... menus) {
		this.title = title;
		this.scan = scan;
		// this.actions = new TreeMap<>();
		for (int i = 0; i < menus.length; i++) {
			this.actions.put(i, menus[i]);

		}
		this.actions.put(99, menuExit);
	}

	public Menu(IPizzaDao dao, OptionMenu menuExit, String title, Scanner scan, OptionMenu... menus) {
		this.dao = dao;
		this.title = title;
		this.scan = scan;
		// this.actions = new TreeMap<>();
		for (int i = 0; i < menus.length; i++) {
			this.actions.put(i, menus[i]);

		}
		this.actions.put(99, menuExit);
	}

	public void afficher() {
		int choice;
		boolean arret = true;
		do {
			System.out.println("****** " + title + " ******");
			actions.entrySet().stream().forEach(optionMenuEntry -> System.out
					.println(optionMenuEntry.getKey() + ". " + optionMenuEntry.getValue().getLibelle()));

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

	public void setActions(OptionMenu menuExit, OptionMenu... menus) {
		for (int i = 0; i < menus.length; i++) {
			this.actions.put(i, menus[i]);

		}
		this.actions.put(99, menuExit);
	}

	public Scanner getScan() {
		return scan;
	}

	public IPizzaDao getDao() {
		return dao;
	}

}
