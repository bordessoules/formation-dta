package fr.pizzeria.model;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Pizza {

	@Column(name = "code", length = 3, nullable = false, unique = true)
	@ToString(uPPERCASE = true)
	private String code;
	@Column(name = "nom", length = 32, nullable = false )
	@ToString
	private String nom;
	@Column(name = "prix",  nullable = false )
	@ToString
	private double prix;
	private static int nbPizza;
	
	@Column(name = "categorie",  nullable = false )
	@Enumerated(EnumType.STRING)
	private CategoriePizza categorie;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",  nullable = false )
	private Integer id;
	@Column(name = "urlImage",  nullable = true )
	private String urlImage;
	public Pizza() {
		super();
	}

	public String toSql() {
		return  " " + this.code + " , " + this.nom + " , " + this.getPrix() + " ,"
				+ this.getCategorie().toString();
	}

	public Pizza(String Code, String Nom, double prix, CategoriePizza cat) {
		this.code = Code;
		this.nom = Nom;
		this.prix = prix;
		this.categorie = cat;
		Pizza.nbPizza++;

	}
	public Pizza(String Code, String Nom, double prix, CategoriePizza cat, String urlImage) {
		this.code = Code;
		this.nom = Nom;
		this.prix = prix;
		this.categorie = cat;
		this.urlImage=urlImage;
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

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param nbPizza
	 *            the nbPizza to set
	 */
	public static void setNbPizza(Integer nbPizza) {
		Pizza.nbPizza = nbPizza;
	}
}
