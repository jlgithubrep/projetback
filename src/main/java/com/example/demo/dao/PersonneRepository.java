package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.example.demo.model.Personne;

//@CrossOrigin
//@RepositoryRestResource(collectionResourceRel = "personnes", itemResourceRel = "personne", path = "personnes")
public interface PersonneRepository extends JpaRepository<Personne, Integer> {
	Personne findByNom(@Param("nom") String nom);
	
	Personne findByNomAndMdp(@Param("nom") String nom, @Param("mdp") String password);
	
	
	Personne findByMailAndMdp(@Param("mail") String mail, @Param("mdp") String password);
	
	
	public Personne findByMail(@Param("mail") String mail);
	// http://localhost:8080/personnes
	// http://localhost:8080/personnes/2

	// http://localhost:8080/personnes/search/findByNom?nom=wick

	// Personne findById(@Param("id") int id);
	//List<Personne> findByNom(@Param("nom") String nom);

	

	// http://localhost:8080/personnes/search/findArticleByNom?nom=bob

//	@Query("SELECT a FROM Article a, Personne p, Redaction where p.nom = :nom and ") 
//    List<Article> findArticleByNom(@Param("nom") String nom);

	// select * from article a, personne p, redaction r where p.nom="bob" and p.id =
	// r.personne_id and r.article_id = a.id_article;
	// select * from article a join redaction r on a.id_article = r.article_id join
	// personne p on p.id = r.personne_id where p.nom="bob";
}
