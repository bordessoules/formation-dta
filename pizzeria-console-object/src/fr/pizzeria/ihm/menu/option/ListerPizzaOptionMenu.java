package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;


public class ListerPizzaOptionMenu extends OptionMenu {

	public ListerPizzaOptionMenu(IPizzaDao pizzaDao) {
		this.libelle = "Lister pizzas ";
		this.pizzaDao=pizzaDao;
	}

	@Override
	public boolean execute() {
		System.out.println("lister pizza menu");
		Pizza[] pizzas = pizzaDao.findAllPizzas();
		for (Pizza p : pizzas) {
			System.out.println(p.getCode() + " -> "+p.getNom() + " ( "+ p.getPrix() + " € )");
		}
		return true;
	}

}
