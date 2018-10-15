package sistemaDeVendas.domains;

import java.time.LocalDate;

public class Fornecedor {

	private String nome;
	private Long telefone;
	private String email;
	private String cnpj;
	private LocalDate dataDeContrato;

	public Fornecedor(String nome, Long telefone, String email, String cnpj, LocalDate dataDeContrato) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cnpj = cnpj;
		this.dataDeContrato = dataDeContrato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public LocalDate getDataDeContrato() {
		return dataDeContrato;
	}

	public void setDataDeContrato(LocalDate dataDeContrato) {
		this.dataDeContrato = dataDeContrato;
	}

}
