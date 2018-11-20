package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Article;
import com.example.demo.model.Commentaire;

//@RepositoryRestResource(
//collectionResourceRel="commentaires",
//itemResourceRel="commentaire",
//path="commentaires")
//@CrossOrigin
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {

	//http://localhost:8080/commentaires
	//http://localhost:8080/commentaires/1

	
}
