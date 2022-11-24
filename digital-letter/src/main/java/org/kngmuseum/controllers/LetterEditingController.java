package org.kngmuseum.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.kngmuseum.dataObjects.Letter;
import org.kngmuseum.service.EmployeeControl;
import org.kngmuseum.service.LettersControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LetterEditingController {

	private int id;

	@Autowired
	EmployeeControl employeeControl;

	@Autowired
	ResourceLoader loader;

	@Autowired
	LettersControl lettersControl;

	@GetMapping(value = "edit_letter")
	public String goToEditingLetterPage(Model model, @RequestParam("sorting") int sorting,
			@RequestParam("user") int idUser) throws IOException {
		String nameEmployee = employeeControl.getNameEmployee(idUser);
		model.addAttribute("user_name", nameEmployee);
		model.addAttribute("idUser", idUser);
		id = idUser;
		if (sorting == 0) {
			model.addAttribute("sel0", "selected");
		} else {
			model.addAttribute("sel1", "selected");
		}
		Letter testletter = lettersControl.getLetterById(22);

		model.addAttribute("author_field", testletter.getAuthor());
		model.addAttribute("heading_field", testletter.getHeading());
		String date = new SimpleDateFormat("yyyy-MM-dd").format(testletter.getDateWriting());
		model.addAttribute("dateWriting_field", date);
		model.addAttribute("locality_field", testletter.getLocality());
		model.addAttribute("textLetter_field", testletter.getText());
//		InputStream is = new ByteArrayInputStream(testletter.getScannedCopy());
//		BufferedImage bi = ImageIO.read(is);
//		try (FileOutputStream stream = new FileOutputStream("currentImageAuthorLetter.png")) {
//			stream.write(testletter.getScannedCopy());
//			model.addAttribute("src_scannedCopy", "currentImageAuthorLetter.png");
//			
//		}

//		File outputFile = new ServletContextResource(servletContext, "currentImageAuthorLetter.jpg").getFile();
//		try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
//			outputStream.write(testletter.getScannedCopy());
//		}

		// File outputFile = new File("images/currentImageAuthorLetter.jpg");
		// getClass().getResourceAsStream("/static/images/currentImageAuthorLetter.jpg");
		String outputFile = new File("src\\main\\resources\\static\\").getAbsolutePath() + "\\"
				+ "currentImageAuthorLetter.jpg";
		System.out.println(outputFile);
		try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
			outputStream.write(testletter.getScannedCopy());
			model.addAttribute("src_scannedCopy", "currentImageAuthorLetter.jpg");

		}

		// model.addAttribute("src_scannedCopy", "currentImageAuthorLetter.png");

		return "editLetter";
	}
}
