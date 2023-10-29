package com.config.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class SpringSecurityEngine{
	
//	@Autowired
//    MvcRequestMatcher.Builder mvc;
	
	//For Password Encoder
	@Bean
	public PasswordEncoder passwordEncoder() {
		//return new BCryptPasswordEncoder();
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
//	@Bean
//    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
//        return new MvcRequestMatcher.Builder(introspector);
//    } 
	
	//For User Details
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails normalUserDetails = User.withUsername("himanshu")
				.password(passwordEncoder()
				.encode("omnie@2161"))
				.roles("NORMAL")
				.build();
		
		UserDetails adminUserDetails = User.withUsername("dushyant")
				.password(passwordEncoder()
				.encode("omnie@2161"))
				.roles("ADMIN")
				.build();
		
		
		
		//return new InMemoryUserDetailsManager(normalUserDetails,adminUserDetails);
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(normalUserDetails,adminUserDetails);
		return inMemoryUserDetailsManager;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
	
//        httpSecurity.csrf(csrf -> csrf.disable())    // csrf() - (Cross-Site Request Forgery) it is a attack to user for provide the authenticated data AND Disable unauthorized request.
				httpSecurity.csrf().disable()
                .authorizeHttpRequests()    
                .requestMatchers("api/user/{id}")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/Login").permitAll();
	
	return httpSecurity.getOrBuild();
	}
	

	  
	  
}
