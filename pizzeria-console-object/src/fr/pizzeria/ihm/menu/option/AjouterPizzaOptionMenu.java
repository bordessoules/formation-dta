package fr.pizzeria.ihm.menu.option;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.CategorieException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {

	private Scanner sc;

	public AjouterPizzaOptionMenu(IPizzaDao pizzaDao, Scanner sc) {
		this.sc = sc;
		this.libelle = "Ajouter pizzas ";
		this.pizzaDao = pizzaDao;
	}

	@Override
	public boolean execute() {
		System.out.println("Ajout d'une nouvelle pizza");
		String code, nom,categorie =null;
		double prix;
		System.out.println("Saisir code pizza : ");
		code = sc.next();
		System.out.println("Saisir nom pizza : ");
		nom = sc.next();
		System.out.println("Saisir prix pizza : ");
		try {
			prix = sc.nextDouble();
			System.out.println("veullez saisir la categorie \n"+Arrays.toString(CategoriePizza.values()));
			 categorie=sc.next();
			try {
				pizzaDao.saveNewPizza(new Pizza(code, nom, prix,CategoriePizza.valueOf(categorie)));
			} catch (SavePizzaException e) {
				System.err.println("erreur le code " + code + "est deja utilisé");
			}
		} catch (InputMismatchException e ) {
			sc.next();
			System.err.println("le prix saisie n'etait au bon format");
		}
		catch (IllegalArgumentException e){
			System.err.println("la categorie "+categorie+"n'est pas reconnue");
		}
		return true;
	}

}
