package br.com.adamastor.uniespflix.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.adamastor.uniespflix.exception.AplicacaoException;
import br.com.adamastor.uniespflix.exception.ExceptionValidacoes;
import br.com.adamastor.uniespflix.model.dto.FilmeDTO;
import br.com.adamastor.uniespflix.model.entity.Filme;
import br.com.adamastor.uniespflix.model.entity.Genero;
import br.com.adamastor.uniespflix.model.form.AtualizacaoFilmeForm;
import br.com.adamastor.uniespflix.model.form.FilmeForm;
import br.com.adamastor.uniespflix.model.repository.FilmeRepository;
import br.com.adamastor.uniespflix.model.repository.GeneroRepository;

@Service
public class FilmeService {
	
	@Autowired
	private FilmeRepository filmeRepository;
	@Autowired
	private GeneroRepository generoRepository;
	
	
	public List<FilmeDTO> buscarTodosFilmes(){
		List<Filme> filmes = filmeRepository.findAll();
		return FilmeDTO.converter(filmes);
	}
	
	public List<FilmeDTO> buscarPorTitulo(String titulo){
		List<Filme> filmes = filmeRepository.findByTituloContains(titulo);
		if (filmes.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.ERRO_FILME_NAO_ENCONTRADO);
		}		
		return FilmeDTO.converter(filmes);
	}
	
	public FilmeDTO buscarPorId(Long id){
		Optional<Filme> resultado = filmeRepository.findById(id);
		if(resultado.isPresent()) {
			return new FilmeDTO(resultado.get());
		}
		throw new AplicacaoException(ExceptionValidacoes.ERRO_FILME_NAO_ENCONTRADO);
	}

	@Transactional(rollbackFor = Exception.class)
	public FilmeDTO cadastrar(FilmeForm form) {
		Filme filme = form.converter();
		
		Optional<Genero> resultado = generoRepository.findByNome(form.getNomeGenero());
		if (resultado.isPresent()) {
			filme.setGenero(resultado.get());
		} else {
			Genero genero = new Genero();
			genero.setNome(form.getNomeGenero().toUpperCase());
			generoRepository.save(genero);
		}
		
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
		throw new AplicacaoException(ExceptionValidacoes.ERRO_FILME_NAO_ENCONTRADO);
	}

	public FilmeDTO atualizar(Long id, AtualizacaoFilmeForm form) {
		Optional<Filme> resultado = filmeRepository.findById(id);
		if(resultado.isPresent()) {
			Filme filme = resultado.get();	
			filmeRepository.save(form.atualizarDados(filme));
			return new FilmeDTO(filme);
		}
		throw new AplicacaoException(ExceptionValidacoes.ERRO_FILME_NAO_ENCONTRADO);
	}
}