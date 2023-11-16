package br.edu.infnet.selllingApp.model.domain;

public class SellingDetails {

	private Integer id;
	private String field;
	private String description;

	@Override
	public String toString() {
		return String.format("id (%d) - field (%s) - description (%s)", id, field, description);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
