package br.com.attornatus.gerenciamentopessoas.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "TB_PESSOA")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pessoaId;

	private String nome;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pessoa", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Endereco> enderecos;

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa(Integer pessoaId, String nome, LocalDate dataNascimento, List<Endereco> enderecos) {
		super();
		this.pessoaId = pessoaId;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.enderecos = enderecos;
	}

	public Integer getPessoaId() { return pessoaId; }

	public void setPessoaId(Integer pessoaId) { this.pessoaId = pessoaId; }

	public String getNome() { return nome; }

	public void setNome(String nome) { this.nome = nome; }

	public LocalDate getDataNascimento() { return dataNascimento; }

	public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

	public List<Endereco> getEnderecos() { return enderecos; }

	public void setEnderecos(List<Endereco> enderecos) { this.enderecos = enderecos; }

	@Override
	public int hashCode() {
		return Objects.hash(dataNascimento, enderecos, pessoaId, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(enderecos, other.enderecos)
				&& Objects.equals(pessoaId, other.pessoaId) && Objects.equals(nome, other.nome);
	}
}
