package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu
{
	private Scanner sc;


	public SupprimerPizzaOptionMenu(IPizzaDao pizzaDao, Scanner sc) {
		this.libelle = "Supprimer pizzas ";
		this.pizzaDao = pizzaDao;
		this.sc=sc;

	}


	@Override
	public boolean execute() {
		String code ;
		System.out.println("entrer code pizza a supprimer : ");
		code = sc.next();		
	return  pizzaDao.deletePizza(code);
	}

}
