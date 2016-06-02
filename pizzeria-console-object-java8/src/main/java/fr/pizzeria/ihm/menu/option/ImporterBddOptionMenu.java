package fr.pizzeria.ihm.menu.option;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.dao.DataAccessException;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoFichierImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ImporterBddOptionMenu extends OptionMenu {

	private static final String AJOUTER_PIZZA_LIBELLE_MENU = "importer pizza vers bdd";

	public ImporterBddOptionMenu(Scanner scanner, IPizzaDao pizzaDao) {
		super(AJOUTER_PIZZA_LIBELLE_MENU, pizzaDao, scanner);

	}	

	@Override
	public boolean execute() {
		List<Pizza>listePizzasInitiales = new ArrayList<>();
		listePizzasInitiales.add(new Pizza("PEP", "Pépéroni", 12.50,CategoriePizza.VIANDE));
		listePizzasInitiales.add(new Pizza("MAR","Margherita", 14.00,CategoriePizza.SANS_VIANDE));
		listePizzasInitiales.add(new Pizza("REI","La Reine", 11.50,CategoriePizza.VIANDE));
		
		listePizzasInitiales.add(new Pizza("FRO", "La 4 fromages", 12.00,CategoriePizza.SANS_VIANDE));
		listePizzasInitiales.add(new Pizza("CAN", "La cannibale", 12.50,CategoriePizza.VIANDE));
		listePizzasInitiales.add(new Pizza("SAV", "La savoyarde", 13.00,CategoriePizza.VIANDE));
		
		listePizzasInitiales.add(new Pizza("ORI", "L'orientale", 13.50,CategoriePizza.VIANDE));
		listePizzasInitiales.add(new Pizza("PEP", "Pépéroni", 12.50,CategoriePizza.VIANDE));

		try {
			pizzaDao.saveAllPizza(listePizzasInitiales, 3);
		} catch (DataAccessException | DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
}
