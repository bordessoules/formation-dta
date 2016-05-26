package fr.pizzeria.admin.metier;

import java.util.Comparator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaServiceJpa {
	@PersistenceContext(unitName = "pizzeria-admin-app")
	private EntityManager em;

	public List<Pizza> findAllPizzas() throws DaoException {

		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p", Pizza.class);
		return query.getResultList();

	}

	public void saveNewPizza(Pizza pizza) throws DaoException {

		em.persist(pizza);

	}

	public void updatePizza(String codePizza, Pizza pizza) throws DaoException {

		TypedQuery<Pizza> q = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:code", Pizza.class)
				.setParameter("code", codePizza);
		Pizza p = q.getSingleResult();
		p.setNom(pizza.getNom());
		p.setCategorie(pizza.getCategorie());
		p.setPrix(pizza.getPrix());

	}

	public void deletePizza(String codePizza) throws DaoException {
		Query q = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:code", Pizza.class).setParameter("code",
				codePizza);
		em.remove(q.getSingleResult());

	}

	public void saveAllPizza(List<Pizza> pizzas, int nb) throws DaoException {
		pizzas.sort(Comparator.comparing(Pizza::getCode));
		ListUtils.partition(pizzas, nb).forEach(list -> {
			list.forEach(em::persist);
		});
	}

}
