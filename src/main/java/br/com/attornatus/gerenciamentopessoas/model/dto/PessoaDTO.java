package br.com.attornatus.gerenciamentopessoas.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.attornatus.gerenciamentopessoas.model.Endereco;

public class PessoaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer pessoaId;
	private String nome;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	private Set<Endereco> enderecos;

	public PessoaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PessoaDTO(Integer pessoaId, String nome, LocalDate dataNascimento, Set<Endereco> enderecos) {
		super();
		this.pessoaId = pessoaId;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.enderecos = enderecos;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(dataNascimento, enderecos, nome, pessoaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaDTO other = (PessoaDTO) obj;
		return Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(enderecos, other.enderecos)
				&& Objects.equals(nome, other.nome) && Objects.equals(pessoaId, other.pessoaId);
	}

	@Override
	public String toString() {
		return "PessoaDTO [pessoaId=" + pessoaId + ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+ ", enderecos=" + enderecos + "]";
	}
}