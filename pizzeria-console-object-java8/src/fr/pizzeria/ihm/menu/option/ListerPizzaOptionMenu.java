package fr.pizzeria.ihm.menu.option;

import java.util.List;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;


public class ListerPizzaOptionMenu extends OptionMenu {

	public ListerPizzaOptionMenu(IPizzaDao pizzaDao) {
		this.libelle = "Lister pizzas ";
		this.pizzaDao=pizzaDao;
	}

	@Override
	public boolean execute() {
		//System.out.println("lister pizza menu");
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		pizzas.stream().forEach(System.out::println);
		
		System.out.println("***** "+Pizza.getNbPizza()+" ******");
		return true;
	}

}
