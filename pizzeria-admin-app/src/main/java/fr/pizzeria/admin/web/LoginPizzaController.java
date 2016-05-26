package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPizzaController
 */
public class LoginPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(PizzaServletWebApi.class.toString());

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPizzaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher =this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login =request.getParameter("login");
		String pass =request.getParameter("pass");
		LOG.info(login + ":"+pass);
		if (login.equals("admin") && pass.equals("admin123")){
			LOG.info("coucou");
			request.getSession().setAttribute("isLogged", true);
			response.sendRedirect(request.getContextPath()+"/pizzas/list");
			LOG.info(request.getSession().getAttribute("isLogged").toString());
		}
		
	}

}
