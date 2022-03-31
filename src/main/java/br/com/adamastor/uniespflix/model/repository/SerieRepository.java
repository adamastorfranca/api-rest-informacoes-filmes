package br.com.adamastor.uniespflix.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.adamastor.uniespflix.model.entity.Serie;

public interface SerieRepository extends CrudRepository<Serie, Long>{
	
	List<Serie> findAll();
	List<Serie> findByTituloContains(String titulo);

}
