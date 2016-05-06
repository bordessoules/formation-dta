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
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaConsoleApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IPizzaDao pizzaDao = new PizzaDaoImpl();
		Menu menu = new Menu(new QuitterOptionMenu(), "admin console", sc, new ListerPizzaOptionMenu(pizzaDao),
				new AjouterPizzaOptionMenu(pizzaDao, sc), new ModifierPizzaMenuOption(pizzaDao, sc),
				new SupprimerPizzaOptionMenu(pizzaDao, sc),new ListerPizzaByCategorieOptionMenu(pizzaDao),new ListerPizzaPrixOptionMenu(pizzaDao));

		menu.afficher();

		sc.close();
	}

}
