package fr.pizzeria.dao.pizza;

import java.util.Comparator;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;
@Named
public class PizzaDaoJpa implements IPizzaDao {
	private EntityManagerFactory emf;

	
	public PizzaDaoJpa(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@Override
	public List<Pizza> findAllPizzas() throws DaoException {

		EntityManager em = emf.createEntityManager();
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p", Pizza.class);
		return query.getResultList();

	}

	@Override
	public void saveNewPizza(Pizza pizza) throws  DaoException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(pizza);
			et.commit();//
		} catch (Exception e) {
			et.rollback();
			throw new DaoException(e);
		} finally {
			em.close();
		}

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza)
			throws  DaoException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			TypedQuery<Pizza> q = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:code", Pizza.class).setParameter("code",
					codePizza);
			Pizza p = q.getSingleResult();
			p.setNom(pizza.getNom());
			p.setCategorie(pizza.getCategorie());
			p.setPrix(pizza.getPrix());
			et.commit();//
		} catch (Exception e) {
			et.rollback();
			System.err.println("la transaction a echoué!!!");
			throw new DaoException(e);
		} finally {
			em.close();
		}

	}

	@Override
	public void deletePizza(String codePizza) throws  DaoException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			Query q = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:code", Pizza.class).setParameter("code",
					codePizza);
			em.remove(q.getSingleResult());
			et.commit();//
		} catch (Exception e) {
			et.rollback();
			System.err.println("la transaction a echoué!!!");
			throw new DaoException(e);
		} finally {
			em.close();
		}
	}
	@Override
	public void saveAllPizza(List<Pizza> pizzas, int nb )throws DaoException{
		EntityManager em = emf.createEntityManager();
		pizzas.sort(Comparator.comparing(Pizza::getCode));
		ListUtils.partition(pizzas,nb).forEach(list -> {
			em.getTransaction().begin();
			list.forEach(em::persist);
			em.getTransaction().commit();
		});
		em.close();
	}

}
