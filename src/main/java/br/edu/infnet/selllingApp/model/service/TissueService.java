package br.edu.infnet.selllingApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.selllingApp.model.domain.Tissue;

@Service
public class TissueService {

	private Map<Integer, Tissue> tissueMap = new HashMap<Integer, Tissue>();

	public void put(Tissue tissue) {
		tissueMap.put(tissue.getId(), tissue);
	}

	public Collection<Tissue> getTissueList() {
		return tissueMap.values();
	}
}
