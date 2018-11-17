package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Override
//  protected void configure(HttpSecurity http) throws Exception {
//  http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().and()
//      .csrf().disable();
//  }

	// https://stackoverflow.com/questions/31027882/spring-security-access-denied-403-after-post
	// https://docs.spring.io/autorepo/docs/spring-security/3.2.0.CI-SNAPSHOT/reference/html/csrf.html

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//	}

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
////		http.cors().and().authorizeRequests().anyRequest().fullyAuthenticated();
////		http.httpBasic();
////		http.csrf().disable();
//
//		//https://docs.spring.io/autorepo/docs/spring-security/3.2.3.RELEASE/apidocs/org/springframework/security/config/annotation/web/builders/HttpSecurity.html
//		
//		http.authorizeRequests()
//		.antMatchers("/login").permitAll()
////		.and()
//		//.authorizeRequests()
//		.antMatchers(HttpMethod.GET,"/personnes").hasRole("administrateur")
//		//.and()
//		//.authorizeRequests()
//		.antMatchers(HttpMethod.GET, "/**").permitAll();
//		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").and().logout()
//				.permitAll();
//	}
	
	
	@Override
  protected void configure(HttpSecurity http) throws Exception {
      http.cors();
      http.authorizeRequests().antMatchers("/login").permitAll()
      .antMatchers("/personnes").hasRole("administrateur")
      .antMatchers(HttpMethod.GET, "/**").permitAll()
      .antMatchers(HttpMethod.POST, "/product", "/product/**", "/category", "/category/**").hasRole("ADMIN")
      .antMatchers(HttpMethod.POST, "/comment", "/comment/**", "/wish", "/wish/**").authenticated()
      .antMatchers(HttpMethod.POST, "/**").permitAll()
      .anyRequest().authenticated().and();
      http.httpBasic();
      http.csrf().disable();
  }
	
	//test
	
	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors();
//        http.authorizeRequests().antMatchers("/signin").permitAll()
//        .antMatchers("/users").hasRole("ADMIN")
//        .antMatchers(HttpMethod.GET, "/**").permitAll()
//        .antMatchers(HttpMethod.POST, "/product", "/product/**", "/category", "/category/**").hasRole("ADMIN")
//        .antMatchers(HttpMethod.POST, "/comment", "/comment/**", "/wish", "/wish/**").authenticated()
//        .antMatchers(HttpMethod.POST, "/**").permitAll()
//        .anyRequest().authenticated().and();
//        http.httpBasic();
//        http.csrf().disable();
//    }
	
	
}
