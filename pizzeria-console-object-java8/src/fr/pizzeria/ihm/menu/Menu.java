package fr.pizzeria.ihm.menu;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import fr.pizzeria.ihm.menu.option.OptionMenu;

public class Menu {
	private String title;
	Map<Integer, OptionMenu> actions;
	private Scanner scan;

	public Menu(OptionMenu menuExit,String title, Scanner scan, OptionMenu... menus) {
		this.title = title;
		this.scan = scan;
		this.actions = new TreeMap<Integer, OptionMenu>();
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
		//	actions.va.stream().forEach(System.out::println);
			actions.entrySet().stream().
			forEach(optionMenuEntry -> System.out.println(optionMenuEntry.getKey() + ". "+optionMenuEntry.getValue().getLibelle()));
			/*for (Integer i : actions.keySet()) {
				System.out.println(i + " " + actions.get(i).getLibelle());
			}
			*/
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
