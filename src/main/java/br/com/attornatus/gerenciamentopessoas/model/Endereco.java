package br.com.attornatus.gerenciamentopessoas.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.attornatus.gerenciamentopessoas.model.enums.TipoEndereco;

@Entity(name = "TB_ENDERECO")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enderecoId;

	private String logradouro;
	private String cep;
	private Integer numero;
	private String cidade;
	
	@Enumerated(EnumType.STRING)
    @Column(name="tipo_endereco")
	private TipoEndereco tipo;

	@JsonIgnore
	//@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "pessoa_id", referencedColumnName = "pessoaId", nullable = false)
	private Pessoa pessoa;

	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endereco(Integer enderecoId, String logradouro, String cep, Integer numero, 
			String cidade, Pessoa pessoa, TipoEndereco tipo) {
		super();
		this.enderecoId = enderecoId;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.pessoa = pessoa;
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

	public Pessoa getPessoa() { return pessoa; }

	public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }
	
	public TipoEndereco getTipo() { return tipo; }
	
	public void setTipo(TipoEndereco tipo) { this.tipo = tipo; }

	@Override
	public int hashCode() {
		return Objects.hash(cep, cidade, enderecoId, logradouro, numero, pessoa, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(enderecoId, other.enderecoId) && Objects.equals(logradouro, other.logradouro)
				&& Objects.equals(numero, other.numero) && Objects.equals(pessoa, other.pessoa) && tipo == other.tipo;
	}

	@Override
	public String toString() {
		return "Endereco [enderecoId=" + enderecoId + ", logradouro=" + logradouro + ", cep=" + cep + ", numero="
				+ numero + ", cidade=" + cidade + ", tipo=" + tipo + ", pessoa=" + pessoa + "]";
	}
}