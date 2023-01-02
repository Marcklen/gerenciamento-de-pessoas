package br.com.attornatus.gerenciamentopessoas.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.gerenciamentopessoas.service.EnderecoService;

@RestController
@RequestMapping("api/v1/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private ModelMapper modelMapper;
}