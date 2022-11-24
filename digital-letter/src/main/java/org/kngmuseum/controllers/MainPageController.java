package org.kngmuseum.controllers;

import org.kngmuseum.service.EmployeeControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainPageController {

	@Autowired
	EmployeeControl employeeControl;

	private int idUser;

	@GetMapping(value = "/main")
	public String goToMainPage(Model model, @RequestParam("user") int user) {
		idUser = user;
		String nameEmployee = employeeControl.getNameEmployee(idUser);
		model.addAttribute("user_name", nameEmployee);
		return "main";
	}

	@GetMapping(value = "/goToLetterCreating")
	public String goToLetterCreating(RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("user", idUser);
		return "redirect:/new_letter";
	}

	@GetMapping(value = "/goToLetterEditing")
	public String goToLetterEditing(RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("user", idUser);
		redirectAttributes.addAttribute("sorting", 0);
		return "redirect:/edit_letter";
	}
}
