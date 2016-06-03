package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@Repository
@Lazy
public class PizzaDaoSpringJpa implements IPizzaDao {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private BatchPizza batchPizza;

	@Transactional
	@Override
	public List<Pizza> findAllPizzas() throws DaoException {

		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p", Pizza.class);
		return query.getResultList();

	}

	@Transactional
	@Override
	public void saveNewPizza(Pizza pizza) throws DaoException {
		em.persist(pizza);
	}

	@Transactional
	@Override
	public void updatePizza(String codePizza, Pizza pizza) {

		TypedQuery<Pizza> q = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:code", Pizza.class)
				.setParameter("code", codePizza);
		Pizza p = q.getSingleResult();
		p.setNom(pizza.getNom());
		p.setCategorie(pizza.getCategorie());
		p.setPrix(pizza.getPrix());

	}

	@Transactional
	@Override
	public void deletePizza(String codePizza) throws DaoException {

		Query q = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:code", Pizza.class).setParameter("code",
				codePizza);
		em.remove(q.getSingleResult());

	}

	@Transactional
	@Override
	public void saveAllPizzas(List<Pizza> pizzas, int nb) throws DaoException {

		ListUtils.partition(pizzas, nb).forEach(batchPizza::save);
	}

}
