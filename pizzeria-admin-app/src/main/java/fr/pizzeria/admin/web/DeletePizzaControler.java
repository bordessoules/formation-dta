package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaServiceJpa;
import fr.pizzeria.exception.DaoException;

/**
 * Servlet implementation class DeletePizzaControler
 */
public class DeletePizzaControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private PizzaServiceJpa pizzaDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePizzaControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		try {
			pizzaDao.deletePizza(code);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
