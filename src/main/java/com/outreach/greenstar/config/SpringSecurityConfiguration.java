/*package com.outreach.greenstar.config;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.outreach.greenstar.entities.Role;
import com.outreach.greenstar.repository.PrivilagesRepository;
import com.outreach.greenstar.repository.RolesRepository;

@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Authentication (Map each user to respective roles)

		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("user").password("password")
				.roles("USER").and().withUser("admin").password("password").roles("USER", "ADMIN");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/api/v1/school/**").hasRole("USER")
		.antMatchers("/api/v1/**").hasRole("ADMIN").and()
		.csrf().disable().headers().frameOptions().disable();
	}

}

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
 
    private static String REALM="MY_TEST_REALM";
    
    @Autowired
    private RolesRepository rolesRepository;
    
    @Autowired
    private PrivilagesRepository privRepository;
     
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        List<Role> list = rolesRepository.findAll();
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Role role = (Role) iterator.next();
            
            auth.inMemoryAuthentication().withUser(role.getRoleName()).password("abc123").roles("ADMIN");
        }
        auth.inMemoryAuthentication().withUser("tom").password("abc123").roles("USER");
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
  
      http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/ap1/v1/**").hasRole("ADMIN")
        .and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//We don't need sessions to be created.
    }
     
    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
        return new CustomBasicAuthenticationEntryPoint();
    }
     
//     To allow Pre-flight [OPTIONS] request from browser 
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}
*/