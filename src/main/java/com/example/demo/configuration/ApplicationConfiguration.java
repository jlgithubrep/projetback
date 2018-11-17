package com.example.demo.configuration;


import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

import com.example.demo.model.Article;
import com.example.demo.model.Commentaire;
import com.example.demo.model.Personne;
import com.example.demo.model.Redaction;

@Component
public class ApplicationConfiguration extends RepositoryRestConfigurerAdapter {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		//config.exposeIdsFor(Personne.class, Article.class, Commentaire.class, Redaction.class);
	}
}

//tilman
//http://tommyziegler.com/how-to-expose-the-resourceid-with-spring-data-rest/