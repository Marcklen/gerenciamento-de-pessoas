package br.com.attornatus.gerenciamentopessoas.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import br.com.attornatus.gerenciamentopessoas.model.Endereco;

public class PessoaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer pessoaId;
	private String nome;
	private LocalDate dataNascimento;
	private Set<Endereco> enderecos;

	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}
