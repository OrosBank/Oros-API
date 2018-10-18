package org.apache.fineract;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(102)
public class SpringSecConfig extends WebSecurityConfigurerAdapter {
	
	
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //httpSecurity.authorizeRequests().antMatchers("/swagger-ui.html","/swagger-resources").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/swagger-resources/**").permitAll().anyRequest().fullyAuthenticated();
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
        
    }

}
