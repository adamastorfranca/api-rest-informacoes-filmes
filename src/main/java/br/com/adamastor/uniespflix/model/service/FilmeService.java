package br.com.adamastor.uniespflix.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adamastor.uniespflix.model.dto.FilmeDTO;
import br.com.adamastor.uniespflix.model.entity.Filme;
import br.com.adamastor.uniespflix.model.form.AtualizacaoFilmeForm;
import br.com.adamastor.uniespflix.model.form.FilmeForm;
import br.com.adamastor.uniespflix.model.repository.FilmeRepository;

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

	public FilmeDTO cadastrar(FilmeForm form) {
		Filme filme = form.converter();
		filmeRepository.save(filme);
		return new FilmeDTO(filme);
	}

	public FilmeDTO atualizar(Long id, AtualizacaoFilmeForm form) {
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