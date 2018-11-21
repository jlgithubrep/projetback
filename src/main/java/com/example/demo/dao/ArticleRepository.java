package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.model.Article;

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
	
	

	List<Article> findByTag(@Param("tag") String tag);
	
	List<Article> findByAuteurArticle(@Param("auteur") String auteur);
	
	@Query("SELECT a.tag FROM Article a")
	List<String> findAllTag();
	
}
