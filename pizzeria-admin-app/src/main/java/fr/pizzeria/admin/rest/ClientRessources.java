package fr.pizzeria.admin.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.ClientService;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Client;

@Path("/clients")
public class ClientRessources {

	@Inject
	private ClientService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> list() {
		List<Client> clients=null;
		try {
			clients = service.findAllClients();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	return clients;

	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Client c) {
		try {
			service.saveNewClient(c);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Client c) {
		try {
			service.updateClient(c.getId(), c);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@DELETE
	@Path("/{id}")
	public void update(@PathParam("id") Integer id) {
		try {
			service.deleteClient(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
