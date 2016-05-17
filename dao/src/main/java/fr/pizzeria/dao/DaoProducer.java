package fr.pizzeria.dao;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.dao.client.ClientDaoJpa;
import fr.pizzeria.dao.pizza.PizzaDaoFichierImpl;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.dao.pizza.PizzaDaoJdbc;
import fr.pizzeria.dao.pizza.PizzaDaoJpa;
import fr.pizzeria.exception.DaoException;

public interface DaoProducer {

	public static IDaoFactory getDaoFactoryJpa(EntityManagerFactory emf) throws DaoException {
		return new GeneriqueDaoFactory(new PizzaDaoJpa(emf), new ClientDaoJpa(emf));
	}
	
	 public default IDaoFactory getDaoFactoryMemoire() {
		return new GeneriqueDaoFactory(new PizzaDaoImpl(), null);
	}
	
	public default IDaoFactory getDaoFactoryFichier() {
		return new GeneriqueDaoFactory(new PizzaDaoFichierImpl(), null);
	}
	
	public default IDaoFactory getDaoFactoryJdbc(String driver, String url, String user, String pass) throws DaoException {
		return new GeneriqueDaoFactory(new PizzaDaoJdbc(driver, url, user, pass), null);
	}
}