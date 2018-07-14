package com.digiAds.gateway.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//@Order(-20)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private Test test;
	
	@PostConstruct
	public void init() {
		System.out.println("########Security Conf" +authenticationManager);
	}
	
	@Bean
	public Test test() {
		return null;
	}

	@Bean( name = "org.springframework.security.authentication.authenticationManager", autowire = Autowire.BY_NAME)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		System.out.println("###########"+authenticationManager);
		
		return super.authenticationManagerBean();
	}

	   /* @Autowired
	    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
	      // @formatter:off
				auth.inMemoryAuthentication()
					.withUser("user").password("password").roles("USER")
				.and()
					.withUser("admin").password("admin").roles("USER", "ADMIN", "READER", "WRITER")
				.and()
					.withUser("audit").password("audit").roles("USER", "ADMIN", "READER");
	// @formatter:on
	    }*/
	    
	    @Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.parentAuthenticationManager(authenticationManager);
		}
	    
	    

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	      // @formatter:off
				http
					.httpBasic().and()
					.logout().and()
					.authorizeRequests()
						.antMatchers("/index.html", "/").permitAll()
						.anyRequest().authenticated()
						.and()
					.csrf()
						.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
				// @formatter:on
	    }
	  

	}

	
