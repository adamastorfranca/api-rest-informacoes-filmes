package br.com.adamastor.uniespflix.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.adamastor.uniespflix.exception.AplicacaoException;
import br.com.adamastor.uniespflix.exception.ExceptionValidacoes;
import br.com.adamastor.uniespflix.model.dto.FilmeRequestDTO;
import br.com.adamastor.uniespflix.model.dto.FilmeResponseDTO;
import br.com.adamastor.uniespflix.model.entity.Filme;
import br.com.adamastor.uniespflix.model.entity.Genero;
import br.com.adamastor.uniespflix.model.form.FilmeAtualizacaoForm;
import br.com.adamastor.uniespflix.model.repository.FilmeRepository;

@Service
public class FilmeService {
	
	@Autowired
	private FilmeRepository repository;
	@Autowired
	private EntityManager em;
	@Autowired
	private GeneroService generoService;

	public List<Filme> buscar(Long id, String titulo) {	
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Filme> cq = cb.createQuery(Filme.class);

        Root<Filme> filme = cq.from(Filme.class);
        Predicate idPredicate = cb.equal(filme.get("id"), id);
        Predicate tituloPredicate = cb.like(filme.get("titulo"), "%" + titulo + "%");
        
        List<Predicate> predicates = new ArrayList<>();
        if (!ObjectUtils.isEmpty(id)) {
        	predicates.add(idPredicate);
		}
        if (!ObjectUtils.isEmpty(titulo)) {
        	predicates.add(tituloPredicate);
		}
        
		cq.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<Filme> query = em.createQuery(cq);
        return query.getResultList();
	}
	
	public Filme cadastrar(FilmeRequestDTO form) {
		Filme filme = form.converter();
		Genero genero = generoService.buscar(form.getIdGenero(), "").get(0);
		filme.setGenero(genero);
		repository.save(filme);	
		return filme;
	}
	
	public void deletar(Long id) {
		Optional<Filme> resultado = repository.findById(id);
		if(resultado.isPresent()) {
			Filme filme = resultado.get();
			repository.delete(filme);
		}
		throw new AplicacaoException(ExceptionValidacoes.ERRO_FILME_NAO_ENCONTRADO);
	}

	public FilmeResponseDTO atualizar(Long id, FilmeAtualizacaoForm form) {
		Optional<Filme> resultado = repository.findById(id);
		if(resultado.isPresent()) {
			Filme filme = resultado.get();	
			repository.save(form.atualizarDados(filme));
			return new FilmeResponseDTO(filme);
		}
		throw new AplicacaoException(ExceptionValidacoes.ERRO_FILME_NAO_ENCONTRADO);
	}
}