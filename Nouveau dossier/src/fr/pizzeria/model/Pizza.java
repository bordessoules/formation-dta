package fr.pizzeria.model;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Pizza {
	// private int id;
	@ToString(uPPERCASE = true)
	private String code;
	@ToString
	private String nom;
	@ToString
	private double prix;
	private static int nbPizza;
	private CategoriePizza categorie;

	public Pizza(String Code, String Nom, double prix, CategoriePizza cat) {
		this.code = Code;
		this.nom = Nom;
		this.prix = prix;
		this.categorie = cat;
		Pizza.nbPizza++;

	}

	@Override
	public String toString() {
		String retour = "";
		for (Field c : this.getClass().getDeclaredFields()) {
			ToString annotation = c.getAnnotation(ToString.class);
			if (annotation != null) {

				try {
					boolean uppercase = annotation.uPPERCASE();
					Object valeurDuChamp = c.get(this);
					retour +=  (uppercase ? valeurDuChamp.toString().toUpperCase() : valeurDuChamp) + " ";
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return retour;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public String getCode() {
		return code;
	}

	public String getNom() {
		return nom;
	}

	public double getPrix() {
		return prix;
	}

	public static int getNbPizza() {
		return nbPizza;
	}

}
