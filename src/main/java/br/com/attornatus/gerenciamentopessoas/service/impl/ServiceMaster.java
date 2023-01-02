package br.com.attornatus.gerenciamentopessoas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class ServiceMaster<T, R extends JpaRepository<T, Integer>> implements ServiceInterface<T> {

	@Autowired
	private R repository;

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<T> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public T create(T object) {
		return repository.save(object);
	}

	@Override
	public T update(Integer id , T object) {
		repository.findById(id);
		return repository.save(object);
	}

	public R getRepository() {
		return repository;
	}
}