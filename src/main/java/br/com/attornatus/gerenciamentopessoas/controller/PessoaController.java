package br.com.attornatus.gerenciamentopessoas.controller;

import java.net.URI;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.attornatus.gerenciamentopessoas.model.Endereco;
import br.com.attornatus.gerenciamentopessoas.model.Pessoa;
import br.com.attornatus.gerenciamentopessoas.model.dto.EnderecoCreateDTO;
import br.com.attornatus.gerenciamentopessoas.model.dto.PessoaDTO;
import br.com.attornatus.gerenciamentopessoas.service.EnderecoService;
import br.com.attornatus.gerenciamentopessoas.service.PessoaService;

@RestController
@RequestMapping("api/v1/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<?> findAllPessoas() {
		try {
			var pessoasList = pessoaService.findAll();
			var resultado = pessoasList.stream().map(pessoa -> 
					modelMapper.map(pessoa, PessoaDTO.class)).toList();
			return ResponseEntity.ok(resultado);
		} catch (RuntimeException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Pessoa pessoa) {
		try {
			pessoa = pessoaService.create(pessoa);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
					.buildAndExpand(pessoa.getPessoaId()).toUri();
			return ResponseEntity.created(uri).body(pessoa);
		} catch (RuntimeException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PostMapping("{pessoaId}/endereco")
	public ResponseEntity<?> createEndereco(@PathVariable Integer pessoaId, 
			@RequestBody EnderecoCreateDTO endCreateDto) {
		try {
			var optionalPessoa = pessoaService.findById(pessoaId);
			if (!optionalPessoa.isPresent()) {
				return ResponseEntity.badRequest().body("Pessoa não encontrada");
			}
			var endereco = modelMapper.map(endCreateDto, Endereco.class);
			endereco.setPessoa(optionalPessoa.get());

			endereco = enderecoService.create(endereco);

			URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
					.buildAndExpand(endereco.getEnderecoId()).toUri();
			
			return ResponseEntity.created(uri).body(endereco);
		} catch (RuntimeException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
}