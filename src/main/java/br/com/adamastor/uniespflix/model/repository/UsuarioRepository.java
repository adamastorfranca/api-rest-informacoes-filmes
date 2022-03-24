package br.com.adamastor.uniespflix.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.adamastor.uniespflix.model.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	List<Usuario> findAll();
	Optional<Usuario> findByEmail(String email);
	
}
