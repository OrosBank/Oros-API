package org.apache.fineract.config;
import org.apache.fineract.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationEntryPoint authEntryPoint;
	
	@Autowired
    UserAuthenticationService userAauthenticationService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/swagger-resources/**").permitAll().anyRequest().fullyAuthenticated();
		http.csrf().disable().authorizeRequests()
				.anyRequest().authenticated()
				.and().httpBasic()
				.authenticationEntryPoint(authEntryPoint);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// Users in memory.
        //auth.inMemoryAuthentication().withUser("telcoil").password("Unix@123").roles("USER");
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("telcoil").password("Unix@123").roles("USER");
        
     // For User in database.
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //auth.userDetailsService(myAppUserDetailsService).passwordEncoder(passwordEncoder);
        //auth.userDetailsService(userAauthenticationService).passwordEncoder(passwordEncoder); //(11)
		
		// Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userAauthenticationService).passwordEncoder(passwordEncoder());   
	}
	/*@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}*/
	
	/*@Bean //(11)
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}*/
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

}
