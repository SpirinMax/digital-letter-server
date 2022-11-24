package org.kngmuseum.dataCrudInterfaces;

import org.kngmuseum.dataObjects.Letter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LettersRepository extends CrudRepository<Letter, Integer> {

}
