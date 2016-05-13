package fr.pizzeria.ihm.menu.option;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class Exporttobdd extends OptionMenu {

	public Exporttobdd(String ajouterPizzaLibelleMenu, IPizzaDao pizzaDao2, Scanner scanner) {
		super(ajouterPizzaLibelleMenu, pizzaDao2, scanner);
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
			
		} catch (Exception e) {
			System.err.println("probleme avec la lecture de application.properties");
		}
	}

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		return false;
	}

}
