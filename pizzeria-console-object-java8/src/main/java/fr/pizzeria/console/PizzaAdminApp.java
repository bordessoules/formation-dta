/*package fr.pizzeria.console;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaAdminApp {

	public static void main(String[] args)  {
		Path root;
		try {
			root = Paths.get("Data");
			Files.list(root).map(path -> {
				Pizza p = new Pizza();
				p.setCode(path.getFileName().toString().replaceAll(".txt", ""));
				try {
					String ligne = Files.readAllLines(path).get(0);
					String[] ligneTab = ligne.split(";");
					p.setNom(ligneTab[0]);
					p.setPrix(Double.valueOf(ligneTab[1]));
					p.setCategorie(CategoriePizza.valueOf(ligneTab[2]));
				} catch (Exception e) {
					e.printStackTrace();
				}
				return p;
			});

		} catch (IOException e) {
			System.err.println("try again");
		}
	}

}
*/

package fr.pizzeria.console;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
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
			IPizzaDao pizzaDao;
			switch (option) {
			case 0:
				pizzaDao = new PizzaDaoImpl();
				break;
			case 1:
				pizzaDao = new PizzaDaoFichierImpl();
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