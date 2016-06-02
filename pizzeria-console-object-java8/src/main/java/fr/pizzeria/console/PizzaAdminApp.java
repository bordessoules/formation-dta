package fr.pizzeria.console;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.ihm.menu.option.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.ImporterBddOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzaByCategorieOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzaPrixOptionMenu;
import fr.pizzeria.ihm.menu.option.ModifierPizzaMenuOption;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;
import fr.pizzeria.ihm.menu.option.SupprimerPizzaOptionMenu;

public class PizzaAdminApp {
	public static void main(String[] args) throws IOException {

		Logger.getLogger("org").setLevel(Level.SEVERE);

		String option = null;
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("application");
			String confString = bundle.getString("dao.impl");
			option = confString;
		} catch (Exception e) {
			System.err.println("probleme avec la lecture de application.properties");
		}
		
		
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzeriaAppSpringConfig.class)) {
		/*
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(option,
				"application-config.xml")) {
		*/
			Menu menu = context.getBean("menu", Menu.class);
			IPizzaDao pizzaDao = (IPizzaDao) context.getBean("dao");// on
																	// pourais
																	// faire un
																	// menu.getDao()
			Scanner sc = context.getBean(Scanner.class);
			menu.setActions(new QuitterOptionMenu(sc, pizzaDao), new ListerPizzaOptionMenu(sc, pizzaDao),
					new AjouterPizzaOptionMenu(sc, pizzaDao), new ModifierPizzaMenuOption(sc, pizzaDao),
					new SupprimerPizzaOptionMenu(sc, pizzaDao), new ListerPizzaByCategorieOptionMenu(sc, pizzaDao),
					new ListerPizzaPrixOptionMenu(sc, pizzaDao),new ImporterBddOptionMenu(sc, pizzaDao));
			menu.afficher();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("");
		}

	}

}