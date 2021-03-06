package fr.pizzeria.ihm.menu.option;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaMenuOption extends OptionMenu {

	private Scanner sc;

	public ModifierPizzaMenuOption(IPizzaDao pizzaDao, Scanner sc) {
		this.libelle = "Modifier pizzas ";
		this.pizzaDao = pizzaDao;
		this.sc = sc;
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
			} catch (UpdatePizzaException | DeletePizzaException | SavePizzaException e) {
				// TODO Auto-generated catch block
				System.err.println("la pizza a modifier n'existe pas (mauvais code pizza)");
			}
		} catch (InputMismatchException e) {
			sc.next();
			System.err.println("le prix saisie n'etait au bon format");
		}

		return true;
	}

}
