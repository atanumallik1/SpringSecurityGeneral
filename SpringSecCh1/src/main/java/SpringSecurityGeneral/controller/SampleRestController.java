package SpringSecurityGeneral.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SampleRestController {
	@GetMapping("/")
	public String hello() {
		return ("Welcome to Spting Boot") ;
	}

}
