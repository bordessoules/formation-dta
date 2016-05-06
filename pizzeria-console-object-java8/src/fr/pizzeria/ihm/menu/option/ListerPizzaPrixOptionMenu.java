package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzaPrixOptionMenu extends OptionMenu {


	public ListerPizzaPrixOptionMenu(IPizzaDao pizzaDao) {
		this.libelle = "Lister pizzas la plus chere ";
		this.pizzaDao=pizzaDao;
	}
	@Override
	public boolean execute() {
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		System.out.println(
				pizzas.stream().collect(Collectors.maxBy(Comparator.comparing(Pizza::getPrix))).get()
				);
		return true;
	}

}
