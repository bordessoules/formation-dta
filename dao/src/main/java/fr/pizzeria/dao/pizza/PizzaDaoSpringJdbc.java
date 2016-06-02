package fr.pizzeria.dao.pizza;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

@Repository
public class PizzaDaoSpringJdbc implements IPizzaDao {
	private class PizzaMapper implements RowMapper<Pizza> {
		@Override
		public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pizza p = new Pizza();
			p.setId(rs.getInt("id"));
			p.setCode(rs.getString("code"));
			p.setNom(rs.getString("nom"));
			p.setPrix(rs.getDouble("prix"));
			p.setUrlImage(rs.getString("urlImage"));

			return p;
		}

	}

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PizzaDaoSpringJdbc(DataSource datasource) {

		this.jdbcTemplate = new JdbcTemplate(datasource);

	}

	@Override
	public List<Pizza> findAllPizzas() throws DaoException {
		String sql = "SELECT * FROM PIZZA";

		return this.jdbcTemplate.query(sql, new PizzaMapper());
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException, DaoException {
		String sql = "INSERT INTO PIZZA (code,nom,prix,categorie) VALUES(?,?,?,?)";

		this.jdbcTemplate.update(sql, pizza.getCode(), pizza.getNom(), pizza.getPrix(),
				pizza.getCategorie().toString());

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		String sql = "UPDATE PIZZA SET  (code=? ,nom=? ,prix=? ,categorie=? ) WHERE code = ? ";

		this.jdbcTemplate.update(sql, codePizza, pizza.getNom(), pizza.getPrix(), pizza.getCategorie().toString(),
				codePizza);

	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException, DaoException {
		String sql = " delete from pizza where code=?";

		this.jdbcTemplate.update(sql, codePizza);
	}

	@Override
	@Transactional
	public void saveAllPizza(List<Pizza> pizzas, int nb) throws DaoException {
		List<List<Pizza>> listpart = ListUtils.partition(pizzas, nb);
		listpart.forEach(lp ->savePizzaTransaction(lp));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void savePizzaTransaction(List<Pizza> pizzas) {

		pizzas.forEach(pizza -> {
			try {
				saveNewPizza(pizza);
			} catch (SavePizzaException e) {
				e.printStackTrace();
			} catch (DaoException e) {
				e.printStackTrace();
			}
		});

	}

}
