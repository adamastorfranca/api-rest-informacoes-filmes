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
import br.com.adamastor.uniespflix.model.dto.GeneroResponseDTO;
import br.com.adamastor.uniespflix.model.entity.Genero;
import br.com.adamastor.uniespflix.model.form.GeneroAtualizacaoForm;
import br.com.adamastor.uniespflix.model.form.GeneroForm;
import br.com.adamastor.uniespflix.model.repository.GeneroRepository;

@Service
public class GeneroService {
	
	@Autowired
	private GeneroRepository repository;
	@Autowired
	private EntityManager em;

	public List<Genero> buscar(Long id, String nome) {	
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Genero> cq = cb.createQuery(Genero.class);

        Root<Genero> genero = cq.from(Genero.class);
        Predicate idPredicate = cb.equal(genero.get("id"), id);
        Predicate nomePredicate = cb.like(genero.get("nome"), "%" + nome + "%");
        
        List<Predicate> predicates = new ArrayList<>();
        if (!ObjectUtils.isEmpty(id)) {
        	predicates.add(idPredicate);
		}
        if (!ObjectUtils.isEmpty(nome)) {
        	predicates.add(nomePredicate);
		}
        
		cq.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<Genero> query = em.createQuery(cq);
        return query.getResultList();
	}

	public GeneroResponseDTO cadastrar(GeneroForm form) {
		Genero genero = form.converter();	
		repository.save(genero);	
		return new GeneroResponseDTO(genero);
	}
	
	public boolean deletar(Long id) {
		Optional<Genero> resultado = repository.findById(id);
		if(resultado.isPresent()) {
			Genero genero = resultado.get();
			repository.delete(genero);
			return resultado.isPresent();
		}
		throw new AplicacaoException(ExceptionValidacoes.ERRO_GENERO_NAO_ENCONTRADO);
	}
	
	public GeneroResponseDTO atualizar(Long id, GeneroAtualizacaoForm form) {
		Optional<Genero> resultado = repository.findById(id);
		if(resultado.isPresent()) {
			Genero genero = resultado.get();	
			repository.save(form.atualizarDados(genero));
			return new GeneroResponseDTO(genero);
		}
		throw new AplicacaoException(ExceptionValidacoes.ERRO_GENERO_NAO_ENCONTRADO);
	}
}