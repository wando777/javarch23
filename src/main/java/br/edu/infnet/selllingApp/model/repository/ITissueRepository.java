package br.edu.infnet.selllingApp.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.selllingApp.model.domain.Tissue;

@Repository
public interface ITissueRepository extends CrudRepository<Tissue, Integer>{

}
