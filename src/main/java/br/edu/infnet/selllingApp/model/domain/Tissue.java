package br.edu.infnet.selllingApp.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Tissue")
public class Tissue extends Product {
	private TissueType type;
	private int lenght;

	public TissueType getType() {
		return type;
	}

	public void setType(TissueType type) {
		this.type = type;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int length) {
		this.lenght = length;
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %d", super.toString(), type, lenght);
	}
}
