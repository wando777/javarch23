package br.edu.infnet.selllingApp.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.selllingApp.model.domain.Clothing;

@Repository
public interface IClothingRepository extends CrudRepository<Clothing, Integer>{

}
