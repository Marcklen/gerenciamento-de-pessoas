package br.com.attornatus.gerenciamentopessoas.service.impl;

import java.util.List;
import java.util.Optional;

//Interface Generica que utilizar o CRUD nos 2 serviços e controllers ( serve para o CRUD de PESSOAS e também de Endereço )
public interface ServiceInterface <T>{

	List<T> findAll();
	Optional<T> findById(Integer id);
	T create (T object);
	T update (Integer id, T object);
//	T delete (T object);
}