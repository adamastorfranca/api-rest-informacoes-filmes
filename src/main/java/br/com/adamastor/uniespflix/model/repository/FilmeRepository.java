package br.com.adamastor.uniespflix.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.adamastor.uniespflix.model.entity.Filme;

public interface FilmeRepository extends CrudRepository<Filme, Long>{
	
	List<Filme> findAll();
	List<Filme> findByTituloContains(String titulo);

}
