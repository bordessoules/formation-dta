package fr.pizzeria.model;

import java.util.Arrays;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Pizza other = (Pizza) obj;
		if (categorie != other.categorie) {
			return false;
		}
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		if (nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!nom.equals(other.nom)) {
			return false;
		}
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix)) {
			return false;
		}
		return true;
	}

}
