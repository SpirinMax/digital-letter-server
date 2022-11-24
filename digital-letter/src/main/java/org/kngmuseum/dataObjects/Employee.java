package org.kngmuseum.dataObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int idEmployee;

	private String name;

	protected Employee() {

	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public String getName() {
		return name;
	}

}
