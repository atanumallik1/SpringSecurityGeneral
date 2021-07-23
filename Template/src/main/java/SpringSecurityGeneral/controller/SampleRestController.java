package SpringSecurityGeneral.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SampleRestController {
	@GetMapping("hello")
	public String hello() {
		return "Welcome to Spring Boot app." ;
	}

}
