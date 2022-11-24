package org.kngmuseum.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.kngmuseum.dataObjects.Letter;
import org.kngmuseum.service.EmployeeControl;
import org.kngmuseum.service.LettersControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LetterNewController {

	@Autowired
	private EmployeeControl employeeControl;

	@Autowired
	private LettersControl lettersControl;

	private int id;

	@GetMapping(value = "new_letter")
	public String goToCreatingLetterPage(Model model, @RequestParam("user") int idUser) {
		id = idUser;
		String nameEmployee = employeeControl.getNameEmployee(idUser);
		model.addAttribute("user_name", nameEmployee);
		model.addAttribute("idUser", idUser);
		return "newletter";
	}

	@PostMapping(value = "create_letter")
	public String createLetter(MultipartHttpServletRequest request, @RequestParam("author") String author,
			@RequestParam("heading") String heading, @RequestParam("dateWriting") String dateWriting,
			@RequestParam("locality") String locality, @RequestParam("textLetter") String textLetter,
			@RequestParam("scannedCopy") MultipartFile scannedCopy,
			@RequestParam("photoAuthor") MultipartFile photoAuthor, RedirectAttributes redirectAttributes)
			throws ParseException {
		Letter letter = new Letter();
		letter.setAuthor(author);
		letter.setDateCreating(new Date());
		letter.setHeading(heading);
		letter.setLocality(locality);
		try {
			letter.setScannedCopy(scannedCopy.getBytes());
			letter.setPhotoAuthor(photoAuthor.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		letter.setText(textLetter);
		letter.setAmountLikes(0);

		Date date = new SimpleDateFormat("yyyy-MM-d", Locale.ENGLISH).parse(dateWriting);
		letter.setDateWriting(date);
		lettersControl.saveLetter(letter);

		redirectAttributes.addAttribute("user", id);

		return "redirect:/new_letter";
	}
}
