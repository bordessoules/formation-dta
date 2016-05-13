package fr.pizzeria.console;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoBdd;
import fr.pizzeria.dao.PizzaDaoFichierImpl;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.ihm.menu.option.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzaByCategorieOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzaPrixOptionMenu;
import fr.pizzeria.ihm.menu.option.ModifierPizzaMenuOption;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;
import fr.pizzeria.ihm.menu.option.SupprimerPizzaOptionMenu;
import fr.pizzeria.model.Pizza;

public class PizzaAdminApp {
	public static void main(String[] args) throws IOException {

		Integer option = -1;

		try {
			ResourceBundle bundle = ResourceBundle.getBundle("application");
			String confString = bundle.getString("dao.impl");
			option = Integer.valueOf(confString);
		} catch (Exception e) {
			System.err.println("probleme avec la lecture de application.properties");
		}

		new Pizza().equals(new Pizza());
		try (Scanner sc = new Scanner(System.in)) {
			IPizzaDao pizzaDao=null;
			switch (option) {
			case 0:
				pizzaDao = new PizzaDaoImpl();
				break;
			case 1:
				pizzaDao = new PizzaDaoFichierImpl();
				break;
			case 2:
				System.out.println("Bdd impl");
				try {
					pizzaDao = new PizzaDaoBdd();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			default:
				System.err.println("dao non configuré regarder application.properties");
				return;
			}
 
			Menu menu = new Menu(new QuitterOptionMenu(sc, pizzaDao), "admin console", sc,
					new ListerPizzaOptionMenu(sc, pizzaDao), new AjouterPizzaOptionMenu(sc, pizzaDao),
					new ModifierPizzaMenuOption(sc, pizzaDao), new SupprimerPizzaOptionMenu(sc, pizzaDao),
					new ListerPizzaByCategorieOptionMenu(sc, pizzaDao), new ListerPizzaPrixOptionMenu(sc, pizzaDao));

			menu.afficher();
		}

	}

}