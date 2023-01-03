package br.com.attornatus.gerenciamentopessoas.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.attornatus.gerenciamentopessoas.model.Endereco;
import br.com.attornatus.gerenciamentopessoas.model.dto.EnderecoDTO;
import br.com.attornatus.gerenciamentopessoas.model.enums.TipoEndereco;
import br.com.attornatus.gerenciamentopessoas.service.EnderecoService;

class EnderecoControllerTest {

	private static final Integer ID = 1;
	private static final String LOGRADOURO = "Av Costa Mar";
	private static final String CEP = "60.170-241";
	private static final Integer NUMERO = 1234;
	private static final String CIDADE = "Fortaleza";
	private static final TipoEndereco TIPO = TipoEndereco.PRINCIPAL;
//	private static final String PESSOA = PESSOA.equals("Marcklen").toString();
	
	private Endereco endereco;
	private EnderecoDTO enderecoDTO;
	
	@InjectMocks
	private EnderecoController controller;
	
	@Mock
	private ModelMapper mapper;

	@Mock
	private EnderecoService service;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		startUser();
	}

	@Test
	void testFindAllEnderecos() {
		when(service.findAll()).thenReturn(List.of(endereco));
		when(mapper.map(any(), any())).thenReturn(enderecoDTO);
		
		ResponseEntity<?> response = controller.findAllEnderecos();
		
		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(ResponseEntity.class, response.getClass());
//		assertEquals(Endereco.class, response.getBody().getClass());
//		assertEquals(EnderecoDTO.class, response.getBody().getClass());
	
//		assertEquals(ID, response.getBody().getClass());
//		assertEquals(LOGRADOURO, response.getBody().getClass());
//		assertEquals(CEP, response.getBody().getClass());
//		assertEquals(NUMERO, response.getBody().getClass());
//		assertEquals(CIDADE, response.getBody().getClass());
//		assertEquals(TIPO, response.getBody().getClass());
	}

	private void startUser() {
		endereco = new Endereco();
//		endereco = new Endereco(ID, LOGRADOURO, CEP, NUMERO, CIDADE, PESSOA, TIPO);
		enderecoDTO = new EnderecoDTO(ID, LOGRADOURO, CEP, NUMERO, CIDADE, TIPO);
	}
}
