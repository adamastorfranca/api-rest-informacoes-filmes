package br.com.adamastor.uniespflix.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adamastor.uniespflix.model.entity.Favorito;
import br.com.adamastor.uniespflix.model.repository.FavoritoRepository;

@Service
public class FavoritoService {

	@Autowired
	private FavoritoRepository favoritoRepository;
	
	public void salvar(Favorito favorito) {
		favoritoRepository.save(favorito);
	}
}
