package br.com.adamastor.filme.model.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adamastor.filme.model.dto.FilmeDTO;
import br.com.adamastor.filme.model.entity.Filme;
import br.com.adamastor.filme.model.form.AtualizacaoFilmeForm;
import br.com.adamastor.filme.model.form.FilmeForm;
import br.com.adamastor.filme.model.repository.FilmeRepository;

@Service
public class FilmeService {
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	public List<FilmeDTO> buscarTodosFilmes(){
		List<Filme> filmes = filmeRepository.findAll();
		return FilmeDTO.converter(filmes);
	}
	
	public List<FilmeDTO> buscarPorTitulo(String titulo){
		List<Filme> filmes = filmeRepository.findByTituloContains(titulo);
		return FilmeDTO.converter(filmes);
	}
	
	public FilmeDTO buscarPorId(Long id){
		Optional<Filme> resultado = filmeRepository.findById(id);
		if(resultado.isPresent()) {
			return new FilmeDTO(resultado.get());
		}
		return null;
	}

	public FilmeDTO cadastrar(@Valid FilmeForm form) {
		Filme filme = form.converter();
		filmeRepository.save(filme);
		return new FilmeDTO(filme);
	}

	public FilmeDTO atualizar(Long id, @Valid AtualizacaoFilmeForm form) {
		Filme filme = form.converter();
		filmeRepository.save(filme);
		return new FilmeDTO(filme);
	}

	public boolean deletar(Long id) {
		Optional<Filme> resultado = filmeRepository.findById(id);
		if(resultado.isPresent()) {
			Filme filme = resultado.get();
			filmeRepository.delete(filme);
			return resultado.isPresent();
		}
		return resultado.isPresent();
	}

}