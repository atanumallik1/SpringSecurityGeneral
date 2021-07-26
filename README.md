# Spring Security Architecture 



### Links
*	https://medium.com/geekculture/spring-security-authentication-process-authentication-flow-behind-the-scenes-d56da63f04fa


## Architecture

![](./Diagram1.drawio.svg)



![](./Diagram2.drawio.svg)


## Authentication 
* `WbSecurityConfigurerAdapter` is our entry point for all configurations 
* `AuthenticationManager` class allows applications to configure Authentication Related settings 
* we need to use `AuthenticationManagerBuilder` to construct `AuthenticationManager`. Sample code may look like
````java
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

Autowired
	PasswordEncoder passwordEncoder; 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		    .withUser("foo")
            // Note that we are encoding the password
            // If we do not encode spring will not accept the password
		    .password(passwordEncoder.encode("foo"))
		    .roles("USER") ;
		
	}

    @Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
}
````

### PasswordEncoder
* Spring Security doe not allow us to deal with bare passwords and always recommends to use a  `PasswordEncoder`
    * You need to pass a `Bean` of type `PasswordEncoder`
    * You need to encode the password of the bean using the Password Encoder 
    * In case you do not want to use the encoder (NOT RECOMMENDED) you can try `NoOpPasswordEncoder` which is deprecated now
    ````java

    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		    .withUser("foo")
            // Note that we are not encoding the password
		    .password("foo")
		    .roles("USER") ;
		
	}

    @Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

    ```` 
### Annotations
#### EnableWebSecurity 
* To switch off the default web application security configuration completely you can add a bean with @EnableWebSecurity` 