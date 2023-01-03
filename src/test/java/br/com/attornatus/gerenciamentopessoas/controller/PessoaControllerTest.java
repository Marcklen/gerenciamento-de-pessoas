package br.com.attornatus.gerenciamentopessoas.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;

import br.com.attornatus.gerenciamentopessoas.model.dto.EnderecoCreateDTO;
import br.com.attornatus.gerenciamentopessoas.service.PessoaService;

class PessoaControllerTest {
	
	@InjectMocks
	private PessoaController controller;
	
	@Mock
	private ModelMapper mapper;
	
	@Mock
	private PessoaService service;
	
	@Mock
	private EnderecoCreateDTO enderecoCreateDTO;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFindAllPessoas() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByIdPessoa() {
		fail("Not yet implemented");
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateEndereco() {
		fail("Not yet implemented");
	}

}
