package fr.pizzeria.model;

public class Pizza {
	//private int id;
	private String code;
	private String nom;
	private double prix;
	private static int nbPizza;
	
	public Pizza ( String Code, String Nom, double prix){
		this.code=Code;
		this.nom=Nom;
		this.prix=prix;
		Pizza.nbPizza++;
				
			
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
