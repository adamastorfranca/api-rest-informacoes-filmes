package br.com.adamastor.uniespflix.model.service;

import java.util.List;
import java.util.Optional;

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
	
	public Plano buscarPlanoPorNome(String nome) {
		Optional<Plano> resultado = planoRepository.findByNomeContains(nome);
		if(resultado.isPresent()) {
			return resultado.get();
		}
		return null;
	}
}