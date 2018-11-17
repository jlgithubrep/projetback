package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the redaction database table.
 * 
 */
@Entity
@NamedQuery(name="Redaction.findAll", query="SELECT r FROM Redaction r")
public class Redaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_redac_association")
	private int idRedacAssociation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_modif")
	private Date dateModif;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="article_id")
	private Article article;

	//bi-directional many-to-one association to Personne
	@ManyToOne
	private Personne personne;

	public Redaction() {
	}

	public int getIdRedacAssociation() {
		return this.idRedacAssociation;
	}

	public void setIdRedacAssociation(int idRedacAssociation) {
		this.idRedacAssociation = idRedacAssociation;
	}

	public Date getDateModif() {
		return this.dateModif;
	}

	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
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