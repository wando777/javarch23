package br.edu.infnet.selllingApp.model.domain;

public class Seller {
	private String name;
	private String cpf;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Seller [name=" + name + ", cpf=" + cpf + ", email=" + email + "]";
	}

}
