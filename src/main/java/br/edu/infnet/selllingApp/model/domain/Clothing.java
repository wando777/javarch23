package br.edu.infnet.selllingApp.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="Clothing")
public class Clothing extends Product {
	@Size(min=1,max=10,message="The brand lenght must have at least 2 characters")
	private String brand;
	private ClothingSize size;
	private String color;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public ClothingSize getSize() {
		return size;
	}

	public void setSize(ClothingSize size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s", super.toString(), brand, size, color);
	}
}
