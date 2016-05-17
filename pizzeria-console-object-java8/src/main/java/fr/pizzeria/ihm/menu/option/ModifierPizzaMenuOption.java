package fr.pizzeria.ihm.menu.option;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import fr.pizzeria.dao.pizza.IPizzaDao;
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
		Pizza newPizza = new Pizza();
		String codeold;
		System.out.println("entrer code pizza a modifier : ");
		codeold = sc.next();
		newPizza.setCode(codeold);
		System.out.println("Veuillez saisir le nom (sans espace)");
		newPizza.setNom(sc.next());
		System.out.println("Veuillez saisir le prix");

		try {
			newPizza.setPrix(sc.nextDouble());
			System.out.println("Veuillez saisir la catégorie");
			CategoriePizza[] categoriePizzas = CategoriePizza.values();
			Arrays.asList(categoriePizzas)
					.forEach(cat -> System.out.println(cat.ordinal() + " -> " + cat.getLibelle()));

			int saisieCategorie = sc.nextInt();
			newPizza.setCategorie(categoriePizzas[saisieCategorie]);

			pizzaDao.updatePizza(codeold, newPizza);
			System.out.println(" pizza modifier");
		} catch (InputMismatchException e) {
			System.err.println("Input " + sc.next() + " n'est pas un nombre");
		} catch (DaoException e) {
			System.err.println("Echec de la modification de la pizza");
		}

		return true;
	}

}
