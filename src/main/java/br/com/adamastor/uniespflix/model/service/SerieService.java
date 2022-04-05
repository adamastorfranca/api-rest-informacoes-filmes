package br.com.adamastor.uniespflix.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.adamastor.uniespflix.exception.AplicacaoException;
import br.com.adamastor.uniespflix.exception.ExceptionValidacoes;
import br.com.adamastor.uniespflix.model.dto.SerieDTO;
import br.com.adamastor.uniespflix.model.entity.Genero;
import br.com.adamastor.uniespflix.model.entity.Serie;
import br.com.adamastor.uniespflix.model.form.SerieAtualizacaoForm;
import br.com.adamastor.uniespflix.model.form.SerieForm;
import br.com.adamastor.uniespflix.model.repository.GeneroRepository;
import br.com.adamastor.uniespflix.model.repository.SerieRepository;

@Service
public class SerieService {
	
	@Autowired
	private SerieRepository serieRepository;
	@Autowired
	private GeneroRepository generoRepository;
	
	public List<SerieDTO> buscarTodasSeries(){
		List<Serie> series = serieRepository.findAll();
		return SerieDTO.converter(series);
	}
	
	public List<SerieDTO> buscarPorTitulo(String titulo){
		List<Serie> series = serieRepository.findByTituloContains(titulo);
		if (series.isEmpty()) {
			throw new AplicacaoException(ExceptionValidacoes.ERRO_SERIE_NAO_ENCONTRADA);
		}		
		return SerieDTO.converter(series);
	}
	
	public SerieDTO buscarPorId(Long id){
		Optional<Serie> resultado = serieRepository.findById(id);
		if(resultado.isPresent()) {
			return new SerieDTO(resultado.get());
		}
		throw new AplicacaoException(ExceptionValidacoes.ERRO_SERIE_NAO_ENCONTRADA);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public SerieDTO cadastrar(SerieForm form) {
		Serie serie = form.converter();
		
		Optional<Genero> resultado = generoRepository.findByNome(form.getNomeGenero());
		if (resultado.isPresent()) {
			serie.setGenero(resultado.get());
		} else {
			Genero genero = new Genero();
			genero.setNome(form.getNomeGenero().toUpperCase());
			generoRepository.save(genero);
			serie.setGenero(genero);
		}
		
		serieRepository.save(serie);	
		return new SerieDTO(serie);
	}
	
	public boolean deletar(Long id) {
		Optional<Serie> resultado = serieRepository.findById(id);
		if(resultado.isPresent()) {
			Serie serie = resultado.get();
			serieRepository.delete(serie);
			return resultado.isPresent();
		}
		throw new AplicacaoException(ExceptionValidacoes.ERRO_SERIE_NAO_ENCONTRADA);
	}
	
	public SerieDTO atualizar(Long id, SerieAtualizacaoForm form) {
		Optional<Serie> resultado = serieRepository.findById(id);
		if(resultado.isPresent()) {
			Serie serie = resultado.get();	
			serieRepository.save(form.atualizarDados(serie));
			return new SerieDTO(serie);
		}
		throw new AplicacaoException(ExceptionValidacoes.ERRO_SERIE_NAO_ENCONTRADA);
	}
}