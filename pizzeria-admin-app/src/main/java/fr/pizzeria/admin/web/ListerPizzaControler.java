package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class ListerPizzaControler
 */
public class ListerPizzaControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(PizzaServletWebApi.class.toString());
	private IPizzaDao pizzaDao = new PizzaDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListerPizzaControler() {
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
			request.setAttribute("listePizzas", pizzas);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/listerPizzas.jsp");
			dispatcher.forward(request, response);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
