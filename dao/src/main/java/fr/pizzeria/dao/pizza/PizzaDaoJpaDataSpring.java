package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.repos.IPizzaRepository;

@Repository
@Lazy
@Transactional
public class PizzaDaoJpaDataSpring implements IPizzaDao {
	@PersistenceContext
	private EntityManager em;

	@Autowired private BatchPizza bp;
	@Autowired private IPizzaRepository pizzaRepository;

	@Override
	public List<Pizza> findAllPizzas() throws DaoException {
		return pizzaRepository.findAll();
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException, DaoException {
		pizzaRepository.save(pizza);

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza)
			throws UpdatePizzaException, DeletePizzaException, SavePizzaException, DaoException {
		pizzaRepository.save(pizza);

	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException, DaoException {
		pizzaRepository.delete(pizzaRepository.findByCode(codePizza));

	}

	@Override
	public void saveAllPizzas(List<Pizza> pizzas, int nb) throws DaoException {
		List<List<Pizza>> lp = ListUtils.partition(pizzas, nb);
		lp.forEach(p -> bp.saveData(p));
	}

}
