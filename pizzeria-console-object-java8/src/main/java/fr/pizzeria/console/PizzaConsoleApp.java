package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.ihm.menu.option.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzaByCategorieOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzaPrixOptionMenu;
import fr.pizzeria.ihm.menu.option.ModifierPizzaMenuOption;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;
import fr.pizzeria.ihm.menu.option.SupprimerPizzaOptionMenu;

public class PizzaConsoleApp {

	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		IPizzaDao pizzaDao = new PizzaDaoImpl();
		Menu menu = new Menu(new QuitterOptionMenu(sc, pizzaDao), "admin console", sc, new ListerPizzaOptionMenu(sc,pizzaDao),
				new AjouterPizzaOptionMenu(sc, pizzaDao), new ModifierPizzaMenuOption(sc, pizzaDao),
				new SupprimerPizzaOptionMenu(sc, pizzaDao ),new ListerPizzaByCategorieOptionMenu(sc,pizzaDao),new ListerPizzaPrixOptionMenu(sc,pizzaDao));

		menu.afficher();

		sc.close();
	}

}
