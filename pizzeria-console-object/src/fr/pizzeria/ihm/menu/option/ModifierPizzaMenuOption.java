package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaMenuOption extends OptionMenu {

	private Scanner sc;

	public ModifierPizzaMenuOption(IPizzaDao pizzaDao, Scanner sc) {
		this.libelle = "Modifier pizzas ";
		this.pizzaDao = pizzaDao;
		this.sc=sc;
	}

	@Override
	public boolean execute() {
		String code ;
			System.out.println("entrer code pizza a modifier : ");
			code = sc.next();
			System.out.println("caracteristique de la pizza");
			String code2, nom;
			double prix;
			System.out.println("Saisir code pizza : ");
			code2 = sc.next();
			System.out.println("Saisir nom pizza : ");
			nom = sc.next();
			System.out.println("Saisir prix pizza : ");
			prix = sc.nextDouble();
			Pizza p = new Pizza(code2, nom, prix);
		return  pizzaDao.updatePizza(code, p);
	}

}
