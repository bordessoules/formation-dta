package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

@Stateless
public class ClientService {
	@PersistenceContext(unitName = "pizzeria-admin-app")
	private EntityManager em;

	public List<Client> findAllClients() throws DaoException {
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);
		return query.getResultList();
	}

	public void saveNewClient(Client c) throws DaoException {
		em.persist(c);

	}

	public void updateClient(Integer id, Client c) throws DaoException {
		TypedQuery<Client> q = em.createQuery("SELECT c FROM Client p WHERE p.code=:code", Client.class)
				.setParameter("id", id);
		Client client = q.getSingleResult();
		if (client != null) {
			client.setId(c.getId());
			client.setEmail(c.getEmail());
			client.setMdp(c.getMdp());
			client.setNom(c.getNom());
			client.setPrenom(c.getPrenom());
		}
	}

	public void deleteClient(Integer id) throws DaoException {
		Query q = em.createQuery("SELECT c FROM Client c WHERE c.id=:id", Pizza.class).setParameter("id",
				id);
		em.remove(q.getSingleResult());

	}

}
