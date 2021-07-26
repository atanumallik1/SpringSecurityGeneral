package SpringSecurityGeneral.Template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "SpringSecurityGeneral.config", "SpringSecurityGeneral.controller" })
public class MySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringApplication.class, args);
	}

}
