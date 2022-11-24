package org.kngmuseum.dataCrudInterfaces;

import java.util.List;

import org.kngmuseum.dataObjects.LoginEmployee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationRepository extends CrudRepository<LoginEmployee, Integer> {
	List<LoginEmployee> findByLogin(String login);
}
