# Spring Security Architecture 



### Links
*	https://medium.com/geekculture/spring-security-authentication-process-authentication-flow-behind-the-scenes-d56da63f04fa



## Authentication 
* `WbSecurityConfigurerAdapter` is out entry point for all configurations 
* `AuthenticationManager` class allows applications to configure Authentication Related settings 
* we need to use `AuthenticationManagerBuilder` to construct `AuthenticationManager`
Sample code may look like
````
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

Autowired
	PasswordEncoder passwordEncoder; 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		    .withUser("foo")
		    .password(passwordEncoder.encode("foo"))
		    .roles("USER") ;
		
	}

    @Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
}
````
