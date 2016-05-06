package fr.pizzeria.model;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
		return Arrays.asList(this.getClass().getDeclaredFields()).stream()
				.filter(field -> field.getAnnotation(ToString.class)!=null)
				.map(field-> {
					try {
						return field.getAnnotation(ToString.class).uPPERCASE()? field.get(this).toString().toUpperCase() : field.get(this).toString() + " ";
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
						return "";
					}
					}).collect(Collectors.joining(" "));
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
