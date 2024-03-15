package com.cedulas.cedulas.repositories;

import com.cedulas.cedulas.entities.Cedula;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CedulaRepository extends CrudRepository<Cedula, Long> {

}
