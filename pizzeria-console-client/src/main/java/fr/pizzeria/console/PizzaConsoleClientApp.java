package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.ihm.menu.option.ConnectionOptionMenu;
import fr.pizzeria.ihm.menu.option.InscriptionOptionMenu;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;

public class PizzaConsoleClientApp {
	
	private PizzaConsoleClientApp() {
		super();
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu(null, new QuitterOptionMenu(), "client console", sc,new InscriptionOptionMenu(),new ConnectionOptionMenu());

		menu.afficher();
	}

	
}
