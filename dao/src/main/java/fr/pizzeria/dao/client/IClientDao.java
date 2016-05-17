package fr.pizzeria.dao.client;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Client;

public interface IClientDao {
	
	void saveClient(Client client) throws DaoException;
	Client getidClient(String email, String mdp)throws DaoException;
}
