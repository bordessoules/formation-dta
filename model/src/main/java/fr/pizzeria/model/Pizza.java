package fr.pizzeria.model;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Pizza {


	@ToString(uPPERCASE = true)
	private String code;
	@ToString
	private String nom;
	@ToString
	private double prix;
	private static int nbPizza;
	private CategoriePizza categorie;

	public Pizza() {
		nbPizza++;

	}

	public Pizza(String Code, String Nom, double prix, CategoriePizza cat) {
		this.code = Code;
		this.nom = Nom;
		this.prix = prix;
		this.categorie = cat;
		Pizza.nbPizza++;

	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return Arrays.asList(this.getClass().getDeclaredFields()).stream()
				.filter(field -> field.getAnnotation(ToString.class) != null).map(field -> {
					try {
						return field.getAnnotation(ToString.class).uPPERCASE()
								? field.get(this).toString().toUpperCase() : field.get(this).toString() + " ";
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

	
	@Override
	public int hashCode() {
		   return HashCodeBuilder.reflectionHashCode(this);
		 }

	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
}
