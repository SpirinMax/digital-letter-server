package org.kngmuseum.service;

import org.kngmuseum.dataCrudInterfaces.AuthorizationRepository;
import org.kngmuseum.dataObjects.LoginEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationEmployee {

	@Autowired
	private AuthorizationRepository authorizationRepository;

	private LoginEmployee loginEmployee;

	public AuthorizationEmployee() {

	}

	public boolean authorizeUser(String loginForm, String passwordFrom) {
		boolean successfulAuth = false;
		if (authorizationRepository.findByLogin(loginForm).isEmpty()) {
			successfulAuth = false;
		} else {
			loginEmployee = authorizationRepository.findByLogin(loginForm).get(0);
//			System.out.println(
//					"\n\n " + "loginBD:" + loginEmployee.getLogin() + "  passwordBD:" + loginEmployee.getPassword());
			if (loginForm.equals(loginEmployee.getLogin()) && passwordFrom.equals(loginEmployee.getPassword())) {
				successfulAuth = true;
			}
		}
		return successfulAuth;
	}

	public LoginEmployee getLoginEmployee() {
		return loginEmployee;
	}

}
