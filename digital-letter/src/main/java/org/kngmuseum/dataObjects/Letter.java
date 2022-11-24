package org.kngmuseum.dataObjects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "letters")
public class Letter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_letter")
	private int idLetter;

	@Column(name = "date_creating")
	private Date dateCreating;

	private String author;

	private String heading;

	@Column(name = "date_writing")
	private Date dateWriting;

	private String text;

	@Column(name = "scanned_copy")
	@Lob
	private byte[] scannedCopy;

	private String locality;

	@Column(name = "amount_likes")
	private int amountLikes;

	@Column(name = "photo_author")
	@Lob
	private byte[] photoAuthor;

	public Letter() {

	}

	public int getAmountLikes() {
		return amountLikes;
	}

	public void setAmountLikes(int amountLikes) {
		this.amountLikes = amountLikes;
	}

	public int getIdLetter() {
		return idLetter;
	}

	public Date getDateCreating() {
		return dateCreating;
	}

	public void setDateCreating(Date dateCreating) {
		this.dateCreating = dateCreating;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public Date getDateWriting() {
		return dateWriting;
	}

	public void setDateWriting(Date dateWriting) {
		this.dateWriting = dateWriting;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public byte[] getScannedCopy() {
		return scannedCopy;
	}

	public void setScannedCopy(byte[] scannedCopy) {
		this.scannedCopy = scannedCopy;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public byte[] getPhotoAuthor() {
		return photoAuthor;
	}

	public void setPhotoAuthor(byte[] photoAuthor) {
		this.photoAuthor = photoAuthor;
	}

	public void setIdLetter(int idLetter) {
		this.idLetter = idLetter;
	}

}
