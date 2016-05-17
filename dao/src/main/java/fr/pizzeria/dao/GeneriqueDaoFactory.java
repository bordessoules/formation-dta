package fr.pizzeria.dao;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;

public class GeneriqueDaoFactory implements IDaoFactory{
	private IClientDao client;
	private  IPizzaDao pizzaDao;
	
	
	public GeneriqueDaoFactory( IPizzaDao pizzaDao,IClientDao client) {
		
		this.client = client;
		this.pizzaDao = pizzaDao;
	}
	@Override
	public IClientDao getClientDao() {
		return client;
	}
	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}
	private void check(Object implementation){
		if (implementation== null) {
			
		}
	}
}
