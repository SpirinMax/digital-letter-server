package org.kngmuseum.dataObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "museum")
public class Museum {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_editing")
	private int id;

	private String schedule;

	private String address;

	@Column(name = "contact_details")
	private String contactDetails;

	private String description;

	protected Museum() {

	}

	public Museum(String schedule, String address, String contactDetails, String description) {
		this.schedule = schedule;
		this.address = address;
		this.contactDetails = contactDetails;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
