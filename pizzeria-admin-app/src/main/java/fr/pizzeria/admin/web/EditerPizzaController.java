package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.admin.metier.PizzaServiceJpa;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class EditerPizzaController
 */
public class EditerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(PizzaServletWebApi.class.toString());

	@Inject
	private PizzaServiceJpa pizzaDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditerPizzaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		getServletContext().setAttribute("categories", CategoriePizza.values());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		if (StringUtils.isBlank(code)) {
			// la requete est mal formaté
			response.sendError(400, "parametre incorrecte");
		} else {

		}
		try {
			List<Pizza> pizzas = pizzaDao.findAllPizzas();
			Optional<Pizza> pizza = pizzas.stream().filter(p -> p.getCode().equals(code)).findFirst();
			request.setAttribute("pizza", pizza.get());
			response.setStatus(200);

			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp");
			dispatcher.forward(request, response);

		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		String cat = request.getParameter("categorie");
		String prix = request.getParameter("prix");
		String urlImage = request.getParameter("urlImage");

		if (StringUtils.isBlank(code) || StringUtils.isBlank(nom) || StringUtils.isBlank(cat)
				|| StringUtils.isBlank(prix)) {
			// la requete est mal formaté
			response.sendError(400, "parametres incorrecte");
		}
		Pizza p = null;
		LOG.info(cat + "  CategoriePizza.valueOf(cat) = ");
		LOG.info(CategoriePizza.valueOf(cat).toString());
		if (StringUtils.isBlank(urlImage)) {
			p = new Pizza(code, nom, Double.parseDouble(prix), CategoriePizza.valueOf(cat));
		} else {
			p = new Pizza(code, nom, Double.parseDouble(prix), CategoriePizza.valueOf(cat), urlImage);

		}
		try {
			pizzaDao.updatePizza(code, p);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/pizzas/list");
	}
}
