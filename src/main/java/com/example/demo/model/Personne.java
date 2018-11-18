package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the personne database table.
 * 
 */
//@CrossOrigin
@Entity
@NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p")
public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private byte abonne;

	private String mail;

	private String mdp;

	private String nom;

	private String prenom;

	private String type;

	// bi-directional many-to-one association to Commentaire
	//@OneToMany(mappedBy="personne")
	@OneToMany
	private List<Commentaire> commentaires;

	// bi-directional many-to-one association to Redaction
//	@OneToMany(mappedBy="personne")
//	private List<Redaction> redactions;
	
	@ManyToMany(cascade={CascadeType.PERSIST,
			CascadeType.REMOVE},fetch = FetchType.EAGER)
			private List <Role> roles = new ArrayList<Role>();

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public boolean add(Role arg0) {
		return roles.add(arg0);
	}

	public boolean remove(Object arg0) {
		return roles.remove(arg0);
	}

	public Personne() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAbonne() {
		return this.abonne;
	}

	public void setAbonne(byte abonne) {
		this.abonne = abonne;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Commentaire addCommentaire(Commentaire commentaire) {
		getCommentaires().add(commentaire);
		commentaire.setPersonne(this);

		return commentaire;
	}

	public Commentaire removeCommentaire(Commentaire commentaire) {
		getCommentaires().remove(commentaire);
		commentaire.setPersonne(null);

		return commentaire;
	}
//
//	public List<Redaction> getRedactions() {
//		return this.redactions;
//	}
//
//	public void setRedactions(List<Redaction> redactions) {
//		this.redactions = redactions;
//	}
//
//	public Redaction addRedaction(Redaction redaction) {
//		getRedactions().add(redaction);
//		//redaction.setPersonne(this);
//
//		return redaction;
//	}
//
//	public Redaction removeRedaction(Redaction redaction) {
//		getRedactions().remove(redaction);
//		//redaction.setPersonne(null);
//
//		return redaction;
//	}

}