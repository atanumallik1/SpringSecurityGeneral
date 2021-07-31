

# JDBC authentication 
## Video Tutorial
Java Brains https://www.youtube.com/watch?v=LKvrFltAgCQ&list=PLqq-6Pq4lTTYTEooakHchTGglSvkZAjnE&index=7 

## We want to build 
* Form Based 
* JDBC auhentication  ( can eb migrated to JDBC - Persistant DB authentication) with Inmemory DB

## Where Does it stand Spring Security Big Picture 

### Pre-read
https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-authentication   

![BigPicture](diagrams/ch2/bigpic.png)

### Spring security Feature Matrix
* [ ] Authorization 
* [x] _**Authentication**_
    * LDAP
    * X509 Certifiate
    * OAuth 2.0 ODIC
    * Central Authentication Service (CAS)
    * Remember Me
    * Preauthorize
    * [x] _**Username / Password based**_  
* [x] Username / PAssword based <br>
Following aspects are to be considered 
    * Reading Username / Pass
        *  [x] _**Form based**_
        *  Basic auth 
        *  Digest ( Deprecared) 
    * Storage Mechanism 
        * In memory DB        
        * [x] _**JDBC based**_ 
            * [x] _**In memory DB**_
            * Persistance DB
        * User Service 
        * LDAP 

## Important Steps 
We want to enable _Form Authentication_ with a JDBC In memory storage . 
### Dependencies
Following dependency is added
````xml
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
````
### Configurations
Following ocnfigurations need to be done in `ApplicationSecurityConfig`which extends `WebSecurityConfigurerAdapter`
#### Form Authentication 
We need to tell our application that it should enforce Form Authentication on all HTTP calls
````java
@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		        .antMatchers("/admin").hasRole("ADMIN")
		        .and().formLogin() ;
    }
````

#### Storage Config
1. We need to autowire a Data source object
2. We need to configure JDBC authentication provider and tell it to the  `AuthenticationManager` using parameter `AuthenticationManagerBuilder`
````java
@Autowired
PasswordEncoder passwordEncoder;

@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
				.withUser(User.withUsername("user").password(passwordEncoder.encode("pass"))
						.roles("USER"))
				.withUser(User.withUsername("admin").password(passwordEncoder.encode("pass"))
						.roles("ADMIN")) ;

	}
````
By default Spring Boot will create `in memory` H2 DB. 
By doing so this much we have implemeted JDBC In Memory persistance based + Form based authentication. 

#### Application properties for storage
 No explicit property is nedeed for the default settings. 

## Details into storage 