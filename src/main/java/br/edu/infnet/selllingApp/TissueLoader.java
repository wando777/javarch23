package br.edu.infnet.selllingApp;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.selllingApp.model.domain.Tissue;
import br.edu.infnet.selllingApp.model.domain.TissueType;
import br.edu.infnet.selllingApp.model.service.TissueService;

@Order(4)
@Component
public class TissueLoader implements ApplicationRunner {

	@Autowired
	private TissueService tissueService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("inputfiles/tissues.txt");
		BufferedReader reader = new BufferedReader(file);
		String row = reader.readLine();
		String[] fields;
		while (row != null) {
			fields = row.split(";");
			Tissue tissue = new Tissue();
			tissue.setDescription(fields[0]);
			tissue.setPrice(Float.valueOf(fields[1]));
			tissue.setCode(Integer.valueOf(fields[2]));
			tissue.setHasStock(Boolean.valueOf(fields[3]));
			tissue.setType(TissueType.valueOf(fields[4]));
			tissue.setLenght(Integer.valueOf(fields[5]));

			tissueService.put(tissue);
			row = reader.readLine();
		}

		for (Tissue tissue : tissueService.getTissueList()) {
			System.out.println("Tissue:" + tissue);
		}

		reader.close();
	}

}
