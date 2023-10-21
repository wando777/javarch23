package br.edu.infnet.selllingApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.selllingApp.model.domain.Clothing;

@Service
public class ClothingService {

	private Map<Integer, Clothing> clothingMap = new HashMap<Integer, Clothing>();

	public void put(Clothing clothing) {
		clothingMap.put(clothing.getId(), clothing);
	}

	public Collection<Clothing> getClothingList() {
		return clothingMap.values();
	}
}
