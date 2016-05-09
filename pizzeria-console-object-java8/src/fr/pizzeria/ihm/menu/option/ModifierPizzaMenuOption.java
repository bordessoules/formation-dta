package fr.pizzeria.ihm.menu.option;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaMenuOption extends OptionMenu {


	
	private static final String AJOUTER_PIZZA_LIBELLE_MENU = "Modifier pizzas";

	public ModifierPizzaMenuOption(Scanner scanner, IPizzaDao pizzaDao) {
		super(AJOUTER_PIZZA_LIBELLE_MENU, pizzaDao, scanner);

	}

	
	@Override
	public boolean execute() {
		String codeold;
		System.out.println("entrer code pizza a modifier : ");
		codeold = sc.next();
		System.out.println("caracteristique de la nouvelle pizza");
		String code2, nom, categorie;
		double prix;
		System.out.println("Saisir code pizza : ");
		code2 = sc.next();
		System.out.println("Saisir nom pizza : ");
		nom = sc.next();
		System.out.println("Saisir prix pizza : ");
		System.out.println("veullez saisir la categorie \n"+Arrays.toString(CategoriePizza.values()));
		categorie=sc.next();
		try {
			prix = sc.nextDouble();
			Pizza p = new Pizza(code2, nom, prix,CategoriePizza.valueOf(categorie));

			try {
				pizzaDao.updatePizza(codeold, p);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InputMismatchException e) {
			sc.next();
			System.err.println("le prix saisie n'etait au bon format");
		}

		return true;
	}

}
