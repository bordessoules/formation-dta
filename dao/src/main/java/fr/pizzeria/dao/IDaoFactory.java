package fr.pizzeria.dao;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;

public interface  IDaoFactory {
	
	
	public  IClientDao getClientDao();
	public  IPizzaDao getPizzaDao();
	}


