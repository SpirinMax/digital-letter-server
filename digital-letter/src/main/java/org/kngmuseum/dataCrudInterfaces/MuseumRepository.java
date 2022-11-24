package org.kngmuseum.dataCrudInterfaces;

import org.kngmuseum.dataObjects.Museum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuseumRepository extends CrudRepository<Museum, Integer> {

}
