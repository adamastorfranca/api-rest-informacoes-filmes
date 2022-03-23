package br.com.adamastor.filme.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.adamastor.filme.model.entity.Filme;

public interface FilmeRepository extends CrudRepository<Filme, Long>{
	
	List<Filme> findAll();
	List<Filme> findByTituloContains(String titulo);

}
