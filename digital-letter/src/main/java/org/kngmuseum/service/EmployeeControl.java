package org.kngmuseum.service;

import org.kngmuseum.dataCrudInterfaces.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeControl {

	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeControl() {

	}

	public String getNameEmployee(int id) {
		String name = employeeRepository.findById(id).get().getName();
		return name;
	}

}
