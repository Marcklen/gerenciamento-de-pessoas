package br.com.attornatus.gerenciamentopessoas.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.attornatus.gerenciamentopessoas.model.Endereco;
import br.com.attornatus.gerenciamentopessoas.model.Pessoa;
import br.com.attornatus.gerenciamentopessoas.model.dto.EnderecoCreateDTO;
import br.com.attornatus.gerenciamentopessoas.model.dto.PessoaDTO;
import br.com.attornatus.gerenciamentopessoas.service.EnderecoService;
import br.com.attornatus.gerenciamentopessoas.service.PessoaService;
import br.com.attornatus.gerenciamentopessoas.service.impl.ServiceMaster;

class PessoaControllerTest {

//	private static final int INDEX = 0;
	private static final Integer ID = 1;
	private static final String NAME = "Marcklen Guimarães";
	private static final LocalDate DATA = LocalDate.of(1986, 01, 03);

	private Optional<Pessoa> pessoa;
	private PessoaDTO pessoaDTO;
	private Endereco endereco;

	@InjectMocks
	private PessoaController controller;

	@Mock
	private ModelMapper mapper;

	@Mock
	private PessoaService service;

	@Mock
	private EnderecoService enderecoService;

	@Mock
	private ServiceMaster<Pessoa, JpaRepository<Pessoa, Integer>> master;

	@Mock
	private EnderecoCreateDTO enderecoCreateDTO;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		startPessoas();
	}

	@Test
	void testFindByIdPessoa() {
		when(service.findById(anyInt())).thenReturn(pessoa);
		when(mapper.map(any(), any())).thenReturn(pessoaDTO);

		ResponseEntity<?> response = controller.findByIdPessoa(ID);

		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(ResponseEntity.class, response.getClass());
//		assertEquals(PessoaDTO.class, response.getBody().getClass());

//		assertEquals(ID, ((Object) response.getBody()).getId());
	}

	@Test
	void testFindAllPessoas() {
		when(service.findAll()).thenReturn(List.of());
		when(mapper.map(any(), any())).thenReturn(pessoaDTO);

		ResponseEntity<?> response = controller.findAllPessoas();

		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(ResponseEntity.class, response.getClass());

//		assertEquals(ID, master.getRepository().findById(ID).get());
//		assertEquals(ID, response.getBody().get(INDEX).getId());
	}

	@Test
	void testCreate() {
		when(service.create(any())).thenReturn(pessoa.get());

		ResponseEntity<?> response = controller.create(pessoa.get());

		assertNotNull(response);
		assertEquals(ResponseEntity.class, response.getClass());
//		assertEquals(HttpStatus.CREATED, response.getStatusCode());
//		assertNotNull(response.getHeaders().get("Location"));
	}

	@Test
	void testUpdate() {
		when(service.update(ID, pessoa.get())).thenReturn(pessoa.get());
		when(mapper.map(any(), any())).thenReturn(pessoaDTO);

		ResponseEntity<?> response = controller.update(ID, pessoa.get());

		assertNotNull(response);
//		assertNotNull(response.getBody());
//		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(ResponseEntity.class, response.getClass());
//		assertEquals(PessoaDTO.class, response.getBody().getClass());

//		assertEquals(ID, response.getBody().getId());
//		assertEquals(NAME, response.getBody().getName());
	}

	@Test
	void testCreateEndereco() {
		when(enderecoService.create(any())).thenReturn(endereco);

		ResponseEntity<?> response = controller.createEndereco(ID, enderecoCreateDTO);

		assertNotNull(response);
		assertEquals(ResponseEntity.class, response.getClass());
//		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	private void startPessoas() {
		// TODO Auto-generated method stub
		pessoa = Optional.ofNullable(new Pessoa(ID, NAME, DATA, null));
		pessoaDTO = new PessoaDTO(ID, NAME, DATA, null);
	}

}
