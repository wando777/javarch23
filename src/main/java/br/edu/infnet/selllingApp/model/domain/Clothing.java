package br.edu.infnet.selllingApp.model.domain;

public class Clothing extends Product {
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
