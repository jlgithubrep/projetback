package com.example.demo.controller;

import java.util.List;

import org.hibernate.loader.plan.exec.process.spi.ReturnReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.dao.CommentaireRepository;
import com.example.demo.model.Article;
import com.example.demo.model.Commentaire;

@CrossOrigin
@RestController
public class CommentaireController {
	@Autowired
	private CommentaireRepository commentaireRepository;

	@Autowired
	private ArticleRepository articleRepository;

	@GetMapping(path = "/commentaires", produces = { "application/json" })
	public List<Commentaire> getCommentaires() {
		return commentaireRepository.findAll();
	}

	@GetMapping(path = "/commentaire/{id}", produces = { "application/json" })
	public Commentaire getArticle(@PathVariable("id") int id) {
		return commentaireRepository.findById(id).orElse(null);
	}

//	@PostMapping(path = "/commentaire", consumes = { "application/json" })
//	public Commentaire addCommentaire(@RequestBody Commentaire comm) {
//
//		return commentaireRepository.save(comm);
//	}

	// https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_JOURNALISTE') or hasRole('ROLE_UTILISATEUR')")
	@PostMapping("/articles/{idArticle}/comment")
	public Commentaire addComment(@PathVariable(value = "idArticle") Integer idArticle, @RequestBody Commentaire comm) {
		return articleRepository.findById(idArticle).map(article -> {
			comm.setArticle(article);
			return commentaireRepository.save(comm);
		}).orElse(null);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_JOURNALISTE') or hasRole('ROLE_UTILISATEUR')")
	@DeleteMapping(path = "/commentaireDelete/{id}", produces = { "application/json" })
	public void deleteCommentaire(@PathVariable("id") int id) {
		commentaireRepository.deleteById(id);
	}

//	@PutMapping(path = "/commentaireUpdate/{id}", consumes = { "application/json" })
//	public Commentaire updateCommentaire(@PathVariable("id") int id, @RequestBody Commentaire commMod) {
//		Commentaire comm = commentaireRepository.findById(id).orElse(null);
//		comm = commMod;
//		return commentaireRepository.saveAndFlush(comm);
//	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_JOURNALISTE') or hasRole('ROLE_UTILISATEUR')")
	@PutMapping("/articles/{idArticle}/comment/{commentId}")
	public Commentaire updateCommentaire(@PathVariable(value = "idArticle") Integer idArticle,
			@PathVariable(value = "commentId") Integer commentId, @RequestBody Commentaire commentMod) {

//		Commentaire commentaire = commentaireRepository.findById(commentId).orElse(null);
//		commentaire = commentMod;
//		return commentaireRepository.saveAndFlush(commentaire);
		
	    return commentaireRepository.findById(commentId).map(comment -> {
            comment.setContenuCommentaire(commentMod.getContenuCommentaire());
            return commentaireRepository.saveAndFlush(comment);
        }).orElse(null);
		
	}

}
