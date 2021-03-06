package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.model.Article;

@CrossOrigin
@RestController
public class ArticleController {
	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping(path="/articles", produces= {"application/json"})
	public List<Article> getArticles() {
		return articleRepository.findAll();
	}
	
	@GetMapping(path="/articles/{id}", produces= {"application/json"})
	public Article getArticle(@PathVariable("id") int id) {
		return articleRepository.findById(id).orElse(null);
	}
	
	@Secured("ROLE_JOURNALISTE")
	@PostMapping(path="/article", consumes= {"application/json"})
	public Article addArticle(@RequestBody Article article) {
		System.out.println(article);
		return articleRepository.save(article);
	}
	
	//@Secured("ROLE_JOURNALISTE")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_JOURNALISTE')")
	@DeleteMapping(path="/articleDelete/{id}", produces= {"application/json"})
	public void deleteArticle(@PathVariable("id") int id) {
		articleRepository.deleteById(id);
	}
	
	@Secured("ROLE_JOURNALISTE")
	@PutMapping(path="/articleUpdate/{id}", consumes= {"application/json"})
	public Article updateArticle(@PathVariable("id") int id, @RequestBody Article articleMod) {	
		Article article = articleRepository.findById(id).orElse(null);
		article = articleMod;
		return articleRepository.saveAndFlush(article);
	}
	
	@Secured("ROLE_JOURNALISTE")
	@GetMapping(value = "/articlesparauteur", params = { "auteur" })
	public List<Article> listeArticleParAuteur(@RequestParam(value = "auteur") String auteur) {
		return articleRepository.findByAuteurArticle(auteur);
	}
	
	@GetMapping(path="/allarticlestags", produces= {"application/json"})
	public Set<String> getAllTags(){
		List<String> tags = articleRepository.findAllTag();
		Set<String> uniqueTags = new HashSet<String>(tags);// Set est une collection sans valeurs doubles
		return uniqueTags;
	}
	
	@GetMapping(path="/articlesbytag", produces = {"application/json"}, params= {"tag"})
	public List<Article> getArticlesByTag(@RequestParam(value="tag") String tag){
		return articleRepository.findByTag(tag);
	}
	
}
