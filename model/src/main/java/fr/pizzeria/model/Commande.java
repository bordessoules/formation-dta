package fr.pizzeria.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	@Column(name = "numero_commande",  nullable = false, unique = false)
	private Integer numero_commande;
	@Enumerated
	@Column(name = "statut",  nullable = false, unique = false)
	private StatutCommande statut;
	
	@Column(name = "date_commande",  nullable = false, unique = false)
	private Date date_commande;
	@ManyToOne(optional=false)
	@JoinColumn(name="livreur_id", nullable=false, updatable=false)
	private Livreur livreur;	
	@ManyToOne
    @JoinColumn(name="client_id", nullable=false)
	private Client client;
	@ManyToMany
	@JoinTable(name="commande_pizza",
    joinColumns=
        @JoinColumn(name="commande_id", referencedColumnName="id"),
    inverseJoinColumns=
        @JoinColumn(name="pizza_id", referencedColumnName="id")
    )
	@Column(name = "pizzas",  nullable = false, unique = false)
	private List<Pizza> pizzas;
	public Commande() {
		super();
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the numero_commande
	 */
	public Integer getNumero_commande() {
		return numero_commande;
	}
	/**
	 * @param numero_commande the numero_commande to set
	 */
	public void setNumero_commande(Integer numero_commande) {
		this.numero_commande = numero_commande;
	}
	/**
	 * @return the statut
	 */
	public StatutCommande getStatut() {
		return statut;
	}
	/**
	 * @param statut the statut to set
	 */
	public void setStatut(StatutCommande statut) {
		this.statut = statut;
	}
	/**
	 * @return the date_commande
	 */
	public Date getDate_commande() {
		return date_commande;
	}
	/**
	 * @param date_commande the date_commande to set
	 */
	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}
	
	/**
	 * @return the pizzas
	 */
	public List<Pizza> getPizzas() {
		return pizzas;
	}
	/**
	 * @param pizzas the pizzas to set
	 */
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	/**
	 * @return the livreur
	 */
	public Livreur getLivreur() {
		return livreur;
	}
	/**
	 * @param livreur the livreur to set
	 */
	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
