package br.com.adamastor.uniespflix.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.adamastor.uniespflix.model.entity.Plano;

public interface PlanoRepository extends CrudRepository<Plano, Long>{
	
	List<Plano> findAll();
	Plano findByNome(String nome);
	

}
