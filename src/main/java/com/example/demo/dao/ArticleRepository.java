package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Article;
import com.example.demo.model.Personne;

//@RepositoryRestResource(
//collectionResourceRel="articles",
//itemResourceRel="article",
//path="articles")
//@CrossOrigin
public interface ArticleRepository extends JpaRepository<Article, Integer> {

	//http://localhost:8080/articles
	//http://localhost:8080/articles/1
	
	Article findByIdArticle(@Param("id") int id);
	List<Article> findByTitre(@Param("titre") String titre);
	
	
	// http://localhost:8080/articles/search/findByTag?tag=sport
	List<Article> findByTag(@Param("tag") String tag);
	
}
