package br.edu.infnet.selllingApp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.selllingApp.model.domain.Tissue;
import br.edu.infnet.selllingApp.model.repository.ITissueRepository;

@Service
public class TissueService {

	@Autowired
	private ITissueRepository tissueRepository;

//	private Map<Integer, Tissue> tissueMap = new HashMap<Integer, Tissue>();

	public void put(Tissue tissue) {
//		tissueMap.put(tissue.getId(), tissue);
		tissueRepository.save(tissue);
	}

	public Collection<Tissue> getTissueList() {
//		return tissueMap.values();
		return (Collection<Tissue>) tissueRepository.findAll();
	}
	
	public long getQuantity() {
		return tissueRepository.count();
	}
}
