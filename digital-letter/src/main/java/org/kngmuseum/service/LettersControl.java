package org.kngmuseum.service;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.kngmuseum.dataCrudInterfaces.LettersRepository;
import org.kngmuseum.dataObjects.Letter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LettersControl {
	@Autowired
	private LettersRepository lettersRepository;

	protected LettersControl() {

	}

	public void saveLetter(Letter letter) {
		lettersRepository.save(letter);
	}

	public Letter getLetterById(int id) {
		return lettersRepository.findById(id).get();
	}

	public List<Letter> getAllLetters() throws IOException {
		List<Letter> target = new ArrayList<>();
		lettersRepository.findAll().iterator().forEachRemaining(target::add);

		for (int i = 0; i < target.size(); i++) {
			byte[] scannedCopyBytes = target.get(i).getScannedCopy();
			byte[] photoAuthorBytes = target.get(i).getPhotoAuthor();
			target.get(i).setScannedCopy(compressImage(scannedCopyBytes));

			if (photoAuthorBytes.length != 0) {
				target.get(i).setPhotoAuthor(compressImage(photoAuthorBytes));
			}
		}

		return target;
	}

	private byte[] compressImage(byte[] bytes) throws IOException {
		try (FileOutputStream fos = new FileOutputStream("currentFile.jpg")) {
			fos.write(bytes);
			fos.close();
		}
		File input = new File("currentFile.jpg");
		BufferedImage image = ImageIO.read(input);

		File compressedImageFile = new File("compressed_image.jpg");
		OutputStream os = new FileOutputStream(compressedImageFile);

		Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
		ImageWriter writer = (ImageWriter) writers.next();

		ImageOutputStream ios = ImageIO.createImageOutputStream(os);
		writer.setOutput(ios);

		ImageWriteParam param = writer.getDefaultWriteParam();

		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		param.setCompressionQuality(0.26f); // Change the quality value you prefer

		writer.write(null, new IIOImage(removeAlphaChannel(image), null, null), param);

		os.close();
		ios.close();
		writer.dispose();

		byte[] compressScannedCopyLetter = Files.readAllBytes(compressedImageFile.toPath());
		return compressScannedCopyLetter;
	}

	private static BufferedImage removeAlphaChannel(BufferedImage img) {
		if (!img.getColorModel().hasAlpha()) {
			return img;
		}
		
		BufferedImage target = createImage(img.getWidth(), img.getHeight(), false);
		Graphics2D g = target.createGraphics();
		g.fillRect(0, 0, img.getWidth(), img.getHeight());
		g.drawImage(img, 0, 0, null);
		g.dispose();
		return target;
	}

	private static BufferedImage createImage(int width, int height, boolean hasAlpha) {
		return new BufferedImage(width, height, hasAlpha ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB);
	}
}
