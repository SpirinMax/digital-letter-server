package org.kngmuseum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroController {

	@GetMapping(value = "/digital-letter")
	public String helloGet() {
		return "index";
	}

}
