package org.kngmuseum.dataCrudInterfaces;

import org.kngmuseum.dataObjects.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
