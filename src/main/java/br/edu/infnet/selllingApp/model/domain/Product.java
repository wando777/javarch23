package br.edu.infnet.selllingApp.model.domain;

public class Product {

	private int id;
	private String description;
	private float price;
	private boolean hasStock;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isHasStock() {
		return hasStock;
	}

	public void setHasStock(boolean hasStock) {
		this.hasStock = hasStock;
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s", id, price, hasStock, description);

	}

}
