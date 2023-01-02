package br.com.attornatus.gerenciamentopessoas.model.dto;

import java.util.Objects;

public class EnderecoCreateDTO {

	private String logradouro;
	private String cep;
	private Integer numero;
	private String cidade;

	public EnderecoCreateDTO() {
		super();
	}

	public EnderecoCreateDTO(String logradouro, String cep, Integer numero, String cidade) {
		super();
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
	}

	public String getLogradouro() { return logradouro; }

	public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

	public String getCep() { return cep; }

	public void setCep(String cep) { this.cep = cep; }

	public Integer getNumero() { return numero; }

	public void setNumero(Integer numero) { this.numero = numero; }

	public String getCidade() { return cidade; }

	public void setCidade(String cidade) { this.cidade = cidade; }

	@Override
	public int hashCode() {
		return Objects.hash(cep, cidade, logradouro, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoCreateDTO other = (EnderecoCreateDTO) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return "EnderecoCreateDTO [logradouro=" + logradouro + ", cep=" + cep + ", numero=" + numero + ", cidade="
				+ cidade + "]";
	}
}