package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class PizzaServletWebApi
 */
public class PizzaServletWebApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(PizzaServletWebApi.class.toString());
	private IPizzaDao pizzaDao = new PizzaDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PizzaServletWebApi() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<Pizza> pizzas = pizzaDao.findAllPizzas();
			response.getWriter().append(pizzas.toString());
		} catch (DaoException e) {
			response.sendError(500, "Desolé :(");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		double prix = Double.parseDouble(request.getParameter("prix"));
		String categorie = request.getParameter("categorie");
		String urlImage = request.getParameter("urlImage");
		LOG.info("j'ai recu la pizza avec les info : " + code + " " + nom + " " + prix + " " + urlImage + " "
				+ categorie);
		if (StringUtils.isBlank(code) || StringUtils.isBlank(nom) || StringUtils.isBlank(request.getParameter("prix"))
				|| StringUtils.isBlank(urlImage) || StringUtils.isBlank(categorie)) {
			LOG.warning("pizza avec des champs vides");
		} else {
			try {
				pizzaDao.saveNewPizza(new Pizza(code, nom, prix, CategoriePizza.valueOf(categorie), urlImage));
			} catch (DaoException e) {
				response.sendError(500, "Desolé :(");
			}

		}
	}

}
