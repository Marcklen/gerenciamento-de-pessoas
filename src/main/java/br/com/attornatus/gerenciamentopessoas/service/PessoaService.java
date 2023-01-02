package br.com.attornatus.gerenciamentopessoas.service;

import org.springframework.stereotype.Service;

import br.com.attornatus.gerenciamentopessoas.model.Pessoa;
import br.com.attornatus.gerenciamentopessoas.repository.PessoaRepository;
import br.com.attornatus.gerenciamentopessoas.service.impl.ServiceMaster;

@Service
public class PessoaService extends ServiceMaster<Pessoa, PessoaRepository> { }