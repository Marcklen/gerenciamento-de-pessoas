package br.com.attornatus.gerenciamentopessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attornatus.gerenciamentopessoas.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{ }