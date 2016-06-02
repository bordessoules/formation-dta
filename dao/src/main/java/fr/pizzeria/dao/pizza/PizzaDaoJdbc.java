package fr.pizzeria.dao.pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;
@Named
public class PizzaDaoJdbc implements IPizzaDao {

	private String fichier = "jdbc";
	private String url ;
	private String driver;
	private String user;
	private String pass;

	public PizzaDaoJdbc() throws ClassNotFoundException {
		super();
		ResourceBundle bundle = ResourceBundle.getBundle(fichier);
		this.url = bundle.getString("jdbc.url");
		this.driver = bundle.getString("jdbc.driver");
		this.user = bundle.getString("jdbc.user");
		this.pass = bundle.getString("jdbc.pass");
		Class.forName(driver);
	}
	public PizzaDaoJdbc(@Value("${jdbc.driver}") String driver, @Value("${jdbc.url}") String url, @Value("${jdbc.user}") String user,@Value("jdbc.pass") String pass)  {
		try {
			Class.forName(driver);
			this.url = url;
			this.user = user;
			this.pass = pass;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);

	}

	@Override
	public List<Pizza> findAllPizzas() throws DaoException {

		List<Pizza> pizzas = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement selectPizzaSt = conn.prepareStatement("SELECT * FROM PIZZA");
				ResultSet resultats = selectPizzaSt.executeQuery();) {
			while (resultats.next()) {

				Pizza pizza = new Pizza();
				pizza.setCode(resultats.getString("code"));
				pizza.setNom(resultats.getString("nom"));
				pizza.setPrix(resultats.getFloat("prix"));
				pizza.setId(resultats.getInt("id"));
				pizzas.add(pizza);
			}
		} catch (SQLException e1) {
			throw new DaoException(e1);
		}

		try (Connection connection = getConnection();
				Statement st = connection.createStatement();
				ResultSet result = st.executeQuery("select * FROM pizza");) {
			while (result.next()) {
				Pizza pizza = new Pizza();
				pizza.setCode(result.getString("code"));
				pizza.setNom(result.getString("nom"));
				pizza.setPrix(result.getFloat("prix"));
				pizza.setId(result.getInt("id"));
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws DaoException {
		try (Connection conn = getConnection();
				PreparedStatement stp = conn
						.prepareStatement("INSERT INTO pizza(code,nom,prix,categorie) VALUES (? , ? , ? , ?)");) {
			stp.setString(1, pizza.getCode());
			stp.setString(2, pizza.getNom());
			stp.setDouble(3, pizza.getPrix());
			stp.setString(4, pizza.getCategorie().toString());
			stp.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		}

	}

	@Override
	public void updatePizza(String codePizza, Pizza updatePizza) throws UpdatePizzaException{
	try (Connection connection = getConnection(); Statement st = connection.createStatement();) {
		int nbLignesAffectes = st.executeUpdate(String.format("update pizza set code='%s',nom='%s',prix=%s,categorie='%s' where code='%s'",updatePizza.getCode(), updatePizza.getNom(), updatePizza.getPrix(), updatePizza.getCategorie().name(), codePizza));

		if (nbLignesAffectes == 0) {
			throw new UpdatePizzaException("Aucune ligne mise à jour en base de données");
		}

	} catch (SQLException e) {
		throw new UpdatePizzaException(e);
	}
	}

	@Override
	public void deletePizza(String codePizza) throws DaoException {
		try (Connection connection = getConnection(); Statement st = connection.createStatement();) {
			int nbLignesAffectes = st.executeUpdate(String.format("delete from pizza where code='%s'", codePizza));

			if (nbLignesAffectes == 0) {
				throw new DeletePizzaException("Aucune ligne supprimée en base de données");
			}

		} catch (SQLException e) {
			throw new DeletePizzaException(e);
		}

	}

	@Override
	public void saveAllPizzas(List<Pizza> pizzas, int nb) throws DaoException {
		throw new DaoException("méthode non implémentée");		
	}


}
