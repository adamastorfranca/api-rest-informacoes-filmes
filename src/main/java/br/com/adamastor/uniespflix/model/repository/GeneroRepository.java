package br.com.adamastor.uniespflix.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.adamastor.uniespflix.model.entity.Genero;

public interface GeneroRepository extends CrudRepository<Genero, Long>{
	
	Optional<Genero> findByNome(String nome);

}
