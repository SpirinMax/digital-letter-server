package org.kngmuseum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MuseumEditingController {
	@GetMapping(value = "museum")
	public String goPageEditingMuseum() {
		return "museum";
	}
}
