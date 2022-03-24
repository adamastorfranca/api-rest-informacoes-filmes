package br.com.adamastor.uniespflix.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.adamastor.uniespflix.model.entity.Favorito;

public interface FavoritoRepository extends CrudRepository<Favorito, Long>{
	
	

}
