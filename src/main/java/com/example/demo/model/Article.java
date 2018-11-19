package com.example.demo.model;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
@CrossOrigin
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_article")
	private Integer idArticle;

	private String auteurArticle;

	@Lob
	private String contenuArticle;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datePublication;

	private String etat;

	private int nbVue;

	private String tag;

	private String titre;

	//bi-directional many-to-one association to Commentaire
	//@OneToMany
	@OneToMany(mappedBy="article")
	private List<Commentaire> commentaires;

//	//bi-directional many-to-one association to Redaction
//	@OneToMany(mappedBy="article")
//	private List<Redaction> redactions;

	public Article() {
	}

	public int getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getAuteurArticle() {
		return this.auteurArticle;
	}

	public void setAuteurArticle(String auteurArticle) {
		this.auteurArticle = auteurArticle;
	}

	public String getContenuArticle() {
		return this.contenuArticle;
	}

	public void setContenuArticle(String contenuArticle) {
		this.contenuArticle = contenuArticle;
	}

	public Date getDatePublication() {
		return this.datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getNbVue() {
		return this.nbVue;
	}

	public void setNbVue(int nbVue) {
		this.nbVue = nbVue;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Commentaire addCommentaire(Commentaire commentaire) {
		getCommentaires().add(commentaire);
		commentaire.setArticle(this);

		return commentaire;
	}

	public Commentaire removeCommentaire(Commentaire commentaire) {
		getCommentaires().remove(commentaire);
		commentaire.setArticle(null);

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

//	public Redaction addRedaction(Redaction redaction) {
//		getRedactions().add(redaction);
//		redaction.setArticle(this);
//
//		return redaction;
//	}
//
//	public Redaction removeRedaction(Redaction redaction) {
//		getRedactions().remove(redaction);
//		redaction.setArticle(null);
//
//		return redaction;
//	}

}