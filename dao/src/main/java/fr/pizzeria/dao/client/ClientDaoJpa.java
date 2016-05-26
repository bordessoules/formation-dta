package fr.pizzeria.dao.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Client;

public class ClientDaoJpa implements IClientDao {

	private EntityManagerFactory emf;

	public ClientDaoJpa(EntityManagerFactory emf) {
		this.emf = emf;
		}

	@Override
	public void saveClient(Client client) throws DaoException {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(client);
			et.commit();//
		} catch (Exception e) {
			et.rollback();
			throw new DaoException(e);
		} finally {
			em.close();
		}

	}

	@Override
	public Client getidClient(String email, String mdp) throws DaoException {
		Client c =null ;
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			TypedQuery<Client> q = em.createQuery("SELECT c FROM Client c WHERE c.email=:email AND c.mdp=:mdp", Client.class)
					.setParameter("email",email)
					.setParameter("mdp",mdp);
			c=q.getSingleResult();
			et.commit();//
		} catch (Exception e) {
			et.rollback();
			System.err.println("la transaction a echoué!!!");
			throw new DaoException(e);
		} finally {
			em.close();
		}
		return c;
	}

}
