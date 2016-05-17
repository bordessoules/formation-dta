package fr.pizzeria.console;

import java.util.Scanner;
import java.util.logging.Level;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.pizzeria.dao.DaoProducer;
import fr.pizzeria.exception.DaoException;
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
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria-console-client");
		Menu menu;
		try {
			menu = new Menu(null, new QuitterOptionMenu(), "client console", sc,
					new InscriptionOptionMenu(sc, DaoProducer.getDaoFactoryJpa(emf)), new ConnectionOptionMenu(DaoProducer.getDaoFactoryJpa(emf),sc));
			menu.afficher();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
