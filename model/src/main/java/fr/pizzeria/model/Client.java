package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Client {
@Id
@Column(name = "id", nullable = false, unique = true)
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
@Column(name = "nom", nullable = false, unique = false)
private String nom;
@Column(name = "prenom", nullable = false, unique = false)
private String prenom;
@Column(name = "email", nullable = false, unique = true)
private String email;
@Column(name = "mdp", nullable = false, unique = false)
private String mdp;
public Client() {
	super();
}
public Client(String nom, String prenom, String email, String mdp) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.mdp = mdp;
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
 * @return the nom
 */
public String getNom() {
	return nom;
}
/**
 * @param nom the nom to set
 */
public void setNom(String nom) {
	this.nom = nom;
}
/**
 * @return the prenom
 */
public String getPrenom() {
	return prenom;
}
/**
 * @param prenom the prenom to set
 */
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return the mdp
 */
public String getMdp() {
	return mdp;
}
/**
 * @param mdp the mdp to set
 */
public void setMdp(String mdp) {
	this.mdp = mdp;
}
}
