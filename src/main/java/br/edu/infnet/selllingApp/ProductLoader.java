package br.edu.infnet.selllingApp;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.selllingApp.model.domain.Clothing;
import br.edu.infnet.selllingApp.model.domain.ClothingSize;
import br.edu.infnet.selllingApp.model.domain.Product;
import br.edu.infnet.selllingApp.model.domain.Seller;
import br.edu.infnet.selllingApp.model.domain.Tissue;
import br.edu.infnet.selllingApp.model.domain.TissueType;
import br.edu.infnet.selllingApp.model.service.ProductService;
import br.edu.infnet.selllingApp.model.service.SellerService;

@Order(2)
@Component
public class ProductLoader implements ApplicationRunner {

	@Autowired
	private ProductService productService;
	@Autowired
	private SellerService sellerService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("inputfiles/products.txt");
		BufferedReader reader = new BufferedReader(file);
		String row = reader.readLine();
		String[] fields;
		Seller seller = new Seller();
		while (row != null) {
			fields = row.split(";");
			switch (fields[fields.length - 1]) {
			case "C":
				Clothing clothing = new Clothing();
				clothing.setCode(Integer.valueOf(fields[0]));
				clothing.setDescription(fields[1]);
				clothing.setPrice(Float.valueOf(fields[2]));
				clothing.setHasStock(Boolean.valueOf(fields[3]));
				clothing.setBrand(fields[4]);
				clothing.setSize(ClothingSize.valueOf(fields[5]));
				clothing.setColor(fields[6]);
				seller.setId(Integer.valueOf(fields[7]));
				clothing.setSeller(seller);
				productService.put(clothing);
				break;
			case "T":
				Tissue tissue = new Tissue();
				tissue.setDescription(fields[0]);
				tissue.setPrice(Float.valueOf(fields[1]));
				tissue.setCode(Integer.valueOf(fields[2]));
				tissue.setHasStock(Boolean.valueOf(fields[3]));
				tissue.setType(TissueType.valueOf(fields[4]));
				tissue.setLenght(Integer.valueOf(fields[5]));
				seller.setId(Integer.valueOf(fields[6]));
				tissue.setSeller(seller);
				productService.put(tissue);
				break;
			default:
				break;
			}

			row = reader.readLine();
		}

		for (Seller s : sellerService.getSellerList()) {
			System.out.println("Products from seller " + s.getId());
			for (Product product : productService.getProductList(s)) {
				System.out.println("Product: " + product);
			}
		}

//		for (Product product : productService.getProductList()) {
//			System.out.println("product:" + product);
//		}

		reader.close();
	}

}
