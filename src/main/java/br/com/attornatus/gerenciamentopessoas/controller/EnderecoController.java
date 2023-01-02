package br.com.attornatus.gerenciamentopessoas.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.gerenciamentopessoas.model.dto.EnderecoDTO;
import br.com.attornatus.gerenciamentopessoas.service.EnderecoService;

@RestController
@RequestMapping("api/v1/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<?> findAllEnderecos() {
		try {
			var enderecoList = enderecoService.findAll();
			var resultado = enderecoList.stream().map(endereco -> modelMapper.map(endereco, EnderecoDTO.class))
					.toList();
			return ResponseEntity.ok(resultado);
		} catch (RuntimeException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
}