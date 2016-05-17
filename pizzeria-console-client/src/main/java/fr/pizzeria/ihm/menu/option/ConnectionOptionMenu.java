package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IDaoFactory;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Client;

public class ConnectionOptionMenu extends OptionMenu {

	
	private static final String LIBELLE_MENU = "Se connecter";

	public ConnectionOptionMenu(IDaoFactory f, Scanner sc) {
		super(LIBELLE_MENU, f, sc);
		
	}
	
	@Override
	public boolean execute() {
		Client c = null;
		System.out.println("Veuillez saisir votre adresse mail");
		String email = sc.next();
		System.out.println("Veuillez saisir votre mot de passe");
		String mdp = sc.next();
		try {
			c= fact.getClientDao().getidClient(email, mdp);
			System.out.println(c);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}