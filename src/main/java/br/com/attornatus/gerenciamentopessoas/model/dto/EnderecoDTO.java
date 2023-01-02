package br.com.attornatus.gerenciamentopessoas.model.dto;

import java.util.Objects;

import br.com.attornatus.gerenciamentopessoas.model.enums.TipoEndereco;

public class EnderecoDTO {

	private Integer enderecoId;
	private String logradouro;
	private String cep;
	private Integer numero;
	private String cidade;
	private TipoEndereco tipo;

	public EnderecoDTO() {
		super();
	}

	public EnderecoDTO(Integer enderecoId, String logradouro, String cep, Integer numero, String cidade, TipoEndereco tipo) {
		super();
		this.enderecoId = enderecoId;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.tipo = tipo;
	}

	public Integer getEnderecoId() { return enderecoId; }

	public void setEnderecoId(Integer enderecoId) { this.enderecoId = enderecoId; }

	public String getLogradouro() { return logradouro; }

	public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

	public String getCep() { return cep; }

	public void setCep(String cep) { this.cep = cep; }

	public Integer getNumero() { return numero; }

	public void setNumero(Integer numero) { this.numero = numero; }

	public String getCidade() { return cidade; }

	public void setCidade(String cidade) { this.cidade = cidade; }
	
	public TipoEndereco getTipo() { return tipo; }
	
	public void setTipo(TipoEndereco tipo) { this.tipo = tipo; }

	@Override
	public int hashCode() {
		return Objects.hash(cep, cidade, enderecoId, logradouro, numero, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoDTO other = (EnderecoDTO) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(enderecoId, other.enderecoId) && Objects.equals(logradouro, other.logradouro)
				&& Objects.equals(numero, other.numero) && tipo == other.tipo;
	}

	@Override
	public String toString() {
		return "EnderecoDTO [enderecoId=" + enderecoId + ", logradouro=" + logradouro + ", cep=" + cep + ", numero="
				+ numero + ", cidade=" + cidade + ", tipo=" + tipo + "]";
	}
}