package org.kngmuseum.controllers;

import java.io.IOException;
import java.util.List;

import org.kngmuseum.dataObjects.Letter;
import org.kngmuseum.service.LettersControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceivingLettersController {

	@Autowired
	private LettersControl lettersControl;

	@GetMapping(value = "/restApi/receiveAllLetters")
	public List<Letter> receiveLetters() throws IOException {
		return lettersControl.getAllLetters();
	}

	@GetMapping(value = "/restApi/receiveLetter")
	public Letter receiveLetterById(@RequestParam("idLetter") int idLetter) {
		return lettersControl.getLetterById(idLetter);
	}

}
