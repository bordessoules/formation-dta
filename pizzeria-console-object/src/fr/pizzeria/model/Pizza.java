package fr.pizzeria.model;

public class Pizza {
	public int id;
	public String Code;
	public String Nom;
	public double prix;
	public static int nbPizza;
	public Pizza ( String Code, String Nom, double prix){
		this.Code=Code;
		this.Nom=Nom;
		this.prix=prix;
		Pizza.nbPizza++;
				
			
	}
	public Pizza() {
		// TODO Auto-generated constructor stub
	}
}
