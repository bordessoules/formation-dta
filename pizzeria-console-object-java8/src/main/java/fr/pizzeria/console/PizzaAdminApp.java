package fr.pizzeria.console;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoFichierImpl;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.dao.pizza.PizzaDaoJdbc;
import fr.pizzeria.dao.pizza.PizzaDaoJpa;
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
					pizzaDao = new PizzaDaoJdbc();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Jpa impl");	
				java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria-console-object-java8");//nom present ds le persitence.xml
				pizzaDao = new PizzaDaoJpa(emf);
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