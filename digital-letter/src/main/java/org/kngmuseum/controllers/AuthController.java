package org.kngmuseum.controllers;

import org.kngmuseum.service.AuthorizationEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

	@Autowired
	private AuthorizationEmployee authEmployee;

	@PostMapping(value = "/auth")
	public ResponseEntity<String> passAuth(@RequestParam("login") String login,
			@RequestParam("password") String password, RedirectAttributes redirectAttributes) {
		if (authEmployee.authorizeUser(login, password)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping(value = "/goMain")
	public String goToMain(RedirectAttributes redirectAttributes) {
		int id = authEmployee.getLoginEmployee().getIdEmployee();
		redirectAttributes.addAttribute("user", id);
		return "redirect:/main";
	}

//	@PostMapping(value = "/auth")
//	public String passAuth(@RequestParam("login") String login, @RequestParam("password") String password,
//			RedirectAttributes redirectAttributes) {
//		if (authEmployee.authorizeUser(login, password)) {
//			int id = authEmployee.getLoginEmployee().getIdEmployee();
//			redirectAttributes.addAttribute("user", id);
//			return "redirect:/main";
//		} else {
//			return "redirect:/unauth";
//		}
//	}
}
