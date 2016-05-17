package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IDaoFactory;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Client;

public class InscriptionOptionMenu extends OptionMenu {

	private static final String LIBELLE_MENU = "S'incrire";

	public InscriptionOptionMenu(Scanner sc,IDaoFactory f) {
		super(LIBELLE_MENU, f, sc);

	}

	@Override
	public boolean execute() {
		System.out.println("Veuillez saisir votre prénom");
		String prenom = sc.next();
		System.out.println("Veuillez saisir votre nom");
		String nom = sc.next();
		System.out.println("Veuillez saisir votre adresse mail");
		String email = sc.next();
		System.out.println("Veuillez saisir votre mot de passe");
		String mdp = sc.next();
		Client c =new Client(nom, prenom, email, mdp);
		try {
			fact.getClientDao().saveClient(c);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return true;
	}

}
