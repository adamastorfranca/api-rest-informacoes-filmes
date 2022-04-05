package br.com.adamastor.uniespflix.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adamastor.uniespflix.exception.AplicacaoException;
import br.com.adamastor.uniespflix.exception.ExceptionValidacoes;
import br.com.adamastor.uniespflix.model.dto.GeneroDTO;
import br.com.adamastor.uniespflix.model.entity.Genero;
import br.com.adamastor.uniespflix.model.form.GeneroAtualizacaoForm;
import br.com.adamastor.uniespflix.model.form.GeneroForm;
import br.com.adamastor.uniespflix.model.repository.GeneroRepository;

@Service
public class GeneroService {
	
	@Autowired
	private GeneroRepository generoRepository;
	
	public List<GeneroDTO> buscarTodosGeneros(){
		List<Genero> generos = generoRepository.findAll();
		return GeneroDTO.converter(generos);
	}
	
	public List<GeneroDTO> buscarPorNome(String nome){
		List<Genero> generos = generoRepository.findByNomeContains(nome);
		if (generos.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.ERRO_GENERO_NAO_ENCONTRADO);
		}		
		return GeneroDTO.converter(generos);
	}
	
	public GeneroDTO buscarPorId(Long id){
		Optional<Genero> resultado = generoRepository.findById(id);
		if(resultado.isPresent()) {
			return new GeneroDTO(resultado.get());
		}
		throw new AplicacaoException(ExceptionValidacoes.ERRO_GENERO_NAO_ENCONTRADO);
	}
	
	public GeneroDTO cadastrar(GeneroForm form) {
		Genero genero = form.converter();	
		generoRepository.save(genero);	
		return new GeneroDTO(genero);
	}
	
	public boolean deletar(Long id) {
		Optional<Genero> resultado = generoRepository.findById(id);
		if(resultado.isPresent()) {
			Genero genero = resultado.get();
			generoRepository.delete(genero);
			return resultado.isPresent();
		}
		throw new AplicacaoException(ExceptionValidacoes.ERRO_GENERO_NAO_ENCONTRADO);
	}
	
	public GeneroDTO atualizar(Long id, GeneroAtualizacaoForm form) {
		Optional<Genero> resultado = generoRepository.findById(id);
		if(resultado.isPresent()) {
			Genero genero = resultado.get();	
			generoRepository.save(form.atualizarDados(genero));
			return new GeneroDTO(genero);
		}
		throw new AplicacaoException(ExceptionValidacoes.ERRO_GENERO_NAO_ENCONTRADO);
	}
}