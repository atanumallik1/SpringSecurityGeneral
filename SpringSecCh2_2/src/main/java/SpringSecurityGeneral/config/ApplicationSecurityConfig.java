package SpringSecurityGeneral.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity(debug = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// users are picked up from data.sql
		auth.jdbcAuthentication()
		    .dataSource(dataSource)
		    .withDefaultSchema()
		    .usersByUsernameQuery("select username,password,enabled "
		            + "from my_users "
		            + "where username = ?")
		          .authoritiesByUsernameQuery("select username,authority "
		            + "from my_authorities "
		            + "where username = ?");
				
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Order of antmachers are important
		// specific to generic we need to maintain ; otherwise if the first one
		// satisfies it does not go to the next ones
		http.authorizeRequests()
		        .antMatchers("/admin").hasRole("ADMIN")
		        .antMatchers("/user").hasAnyRole("USER").and().formLogin() ;
		
		
		
		// We need to enable following settings to access the H2 DB console 
		// Following configurations are done on the HTTP level 
		// We are also registering a WenServlet of H2 DB in the WebConfiguration 
		// class
		
		
		http.authorizeRequests()
	    .antMatchers("/h2-console/**").permitAll();
		
		http.csrf().ignoringAntMatchers("/console/**", "/h2-console/**");
	    http.headers().frameOptions().disable();	 

	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder(10);

	}

}
