package com.example.demo.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.PersonneRepository;
import com.example.demo.model.Personne;


@CrossOrigin
@RestController
public class PersonneController {
	
	@Autowired
	private PersonneRepository personneRepository;
	
	@Secured("ROLE_ADMIN")
	@GetMapping(path="/personnes", produces= {"application/json"})
	public List<Personne> getPersonnes() {
		return personneRepository.findAll();
	}
	@GetMapping(path="/personnes/{id}", produces= {"application/json"})
	public Personne getPersonne(@PathVariable("id") int id) {
		return personneRepository.findById(id).orElse(null);
	}
	@PostMapping(path="/personne", consumes= {"application/json"})
	public Personne addPersonne(@RequestBody Personne personne) {
		System.out.println(personne);
		return personneRepository.save(personne);
	}
	@DeleteMapping(path="/personneDelete/{id}", produces= {"application/json"})
	public void deletePersonne(@PathVariable("id") int id) {
		personneRepository.deleteById(id);
	}
	@PutMapping(path="/personneUpdate/{id}", consumes= {"application/json"})
	public Personne updatePersonne(@PathVariable("id") int id, @RequestBody Personne personneMod) {	
		Personne personne = personneRepository.findById(id).orElse(null);
		personne = personneMod;
		return personneRepository.saveAndFlush(personne);
	}
	
	@GetMapping(value = "/personneLogin", params = { "mail","mdp" })
	public Personne sayHello(@RequestParam(value = "mail") String mail, @RequestParam(value="mdp") String mdp) {
		return personneRepository.findByMailAndMdp(mail, mdp);
	}
	
	
}