package br.com.adamastor.filme.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adamastor.filme.model.dto.FilmeDTO;
import br.com.adamastor.filme.model.entity.Filme;
import br.com.adamastor.filme.model.repository.FilmeRepository;

@Service
public class FilmeService {
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	public List<FilmeDTO> buscarTodosFilmes(){
		List<Filme> filmes = filmeRepository.findAll();
		return FilmeDTO.converter(filmes);
	}

}