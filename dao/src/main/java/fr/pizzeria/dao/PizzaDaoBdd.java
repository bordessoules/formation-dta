package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoBdd implements IPizzaDao {

	private String fichier = "jdbc";
	private String url = "";
	private String driver;
	private String user;
	private String pass;
	private String db;

	public PizzaDaoBdd() {
		super();
		ResourceBundle bundle = ResourceBundle.getBundle(fichier);
		this.url = bundle.getString("url");
		this.driver = bundle.getString("driver");
		this.user = bundle.getString("user");
		this.pass = bundle.getString("pass");
		this.db = bundle.getString("db");

	}

	@Override
	public List<Pizza> findAllPizzas() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException, DaoException {
		
		try {
			Class.forName("com." + db + ".jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			Statement statement  = connection.createStatement();
			ResultSet r = statement.executeQuery(
					"INSERT INTO `pizza` (`code`, `nom`, `prix`, `categorie`) VALUES" + pizza.toSql()
					);
				r.close();
					
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza)
			throws UpdatePizzaException, DeletePizzaException, SavePizzaException, DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException, DaoException {
		// TODO Auto-generated method stub

	}

}
