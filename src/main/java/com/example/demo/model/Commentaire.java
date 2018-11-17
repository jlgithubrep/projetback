package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;


/**
 * The persistent class for the commentaire database table.
 * 
 */
@Entity
@NamedQuery(name="Commentaire.findAll", query="SELECT c FROM Commentaire c")
@CrossOrigin
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCommentaire;

	private String auteurCommentaire;

	@Lob
	private String contenuCommentaire;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCommentaire;

	private String etatCommentaire;

	//bi-directional many-to-one association to Article
	//@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;

	//bi-directional many-to-one association to Personne
	//@ManyToOne
	@JoinColumn(name="idPersonne")
	private Personne personne;

	public Commentaire() {
	}

	public int getIdCommentaire() {
		return this.idCommentaire;
	}

	public void setIdCommentaire(int idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	public String getAuteurCommentaire() {
		return this.auteurCommentaire;
	}

	public void setAuteurCommentaire(String auteurCommentaire) {
		this.auteurCommentaire = auteurCommentaire;
	}

	public String getContenuCommentaire() {
		return this.contenuCommentaire;
	}

	public void setContenuCommentaire(String contenuCommentaire) {
		this.contenuCommentaire = contenuCommentaire;
	}

	public Date getDateCommentaire() {
		return this.dateCommentaire;
	}

	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}

	public String getEtatCommentaire() {
		return this.etatCommentaire;
	}

	public void setEtatCommentaire(String etatCommentaire) {
		this.etatCommentaire = etatCommentaire;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

}