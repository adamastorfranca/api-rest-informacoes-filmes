package br.com.adamastor.uniespflix.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adamastor.uniespflix.model.dto.PlanoDTO;
import br.com.adamastor.uniespflix.model.entity.Plano;
import br.com.adamastor.uniespflix.model.repository.PlanoRepository;

@Service
public class PlanoService {
	
	@Autowired
	private PlanoRepository planoRepository;
	
	public List<PlanoDTO> buscarTodosPlanos(){
		List<Plano> planos = planoRepository.findAll();
		planos.remove(planos.get(3));
		return PlanoDTO.converter(planos);
	}
}