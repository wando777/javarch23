package br.edu.infnet.selllingApp.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.selllingApp.model.domain.Clothing;
import br.edu.infnet.selllingApp.model.repository.IClothingRepository;

@Service
public class ClothingService {
	
	@Autowired
	private IClothingRepository clothingRepository;

//	private Map<Integer, Clothing> clothingMap = new HashMap<Integer, Clothing>();

	public void put(Clothing clothing) {
//		clothingMap.put(clothing.getId(), clothing);
		clothingRepository.save(clothing);
	}

	public Collection<Clothing> getClothingList() {
//		return clothingMap.values();
		return (Collection<Clothing>) clothingRepository.findAll();
	}
}
