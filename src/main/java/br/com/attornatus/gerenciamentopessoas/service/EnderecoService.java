package br.com.attornatus.gerenciamentopessoas.service;

import org.springframework.stereotype.Service;

import br.com.attornatus.gerenciamentopessoas.model.Endereco;
import br.com.attornatus.gerenciamentopessoas.repository.EnderecoRepository;
import br.com.attornatus.gerenciamentopessoas.service.impl.ServiceMaster;

@Service
public class EnderecoService extends ServiceMaster<Endereco, EnderecoRepository> { }