package fr.pizzeria.model;

public class Pizza {
	//private int id;
	private String code;
	private String nom;
	private double prix;
	private static int nbPizza;
	private CategoriePizza categorie;
	public Pizza ( String Code, String Nom, double prix,CategoriePizza cat){
		this.code=Code;
		this.nom=Nom;
		this.prix=prix;
		this.categorie=cat;
		Pizza.nbPizza++;
				
			
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.code+" "+this.nom+" "+this.prix+" € "+this.categorie;
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
