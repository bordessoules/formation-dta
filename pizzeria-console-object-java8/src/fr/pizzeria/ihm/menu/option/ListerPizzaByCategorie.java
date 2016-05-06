package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;
import java.util.List;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzaByCategorie extends OptionMenu {


	public ListerPizzaByCategorie(IPizzaDao pizzaDao) {
		this.libelle = "Lister pizzas par categorie ";
		this.pizzaDao=pizzaDao;
	}
	@Override
	public boolean execute() {
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		pizzas.stream().sorted(Comparator.comparing(Pizza::getCategorie)).forEachOrdered(t -> System.out.println(t.getCategorie().toString()+" "+t));
		return true;
	}

}
