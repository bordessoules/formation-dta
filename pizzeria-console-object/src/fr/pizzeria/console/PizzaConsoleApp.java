package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.menu.Menu;
import fr.pizzeria.ihm.menu.option.ListerPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;

public class PizzaConsoleApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IPizzaDao pizzaDao=new PizzaDaoImpl();
		Menu menu = new Menu( "admin console",sc ,new ListerPizzaOptionMenu(pizzaDao),new QuitterOptionMenu() );
		menu.afficher();
	}

}
