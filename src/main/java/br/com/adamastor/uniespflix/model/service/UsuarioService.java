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
import br.com.adamastor.uniespflix.model.dto.UsuarioRequestDTO;
import br.com.adamastor.uniespflix.model.entity.Cartao;
import br.com.adamastor.uniespflix.model.entity.Favorito;
import br.com.adamastor.uniespflix.model.entity.Plano;
import br.com.adamastor.uniespflix.model.entity.Usuario;
import br.com.adamastor.uniespflix.model.form.UsuarioAtualizacaoForm;
import br.com.adamastor.uniespflix.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private EntityManager em;
	@Autowired
	private CartaoService cartaoService;
	@Autowired
	private PlanoService planoService;
	@Autowired
	private FavoritoService favoritoService;

	public List<Usuario> buscar(Long id, String nome, String email) {	
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);

        Root<Usuario> usuario = cq.from(Usuario.class);
        Predicate idPredicate = cb.equal(usuario.get("id"), id);
        Predicate nomePredicate = cb.like(usuario.get("nome"), "%" + nome + "%");
        Predicate emailPredicate = cb.equal(usuario.get("email"), email);
        
        List<Predicate> predicates = new ArrayList<>();
        if (!ObjectUtils.isEmpty(id)) {
        	predicates.add(idPredicate);
		}
        if (!ObjectUtils.isEmpty(nome)) {
        	predicates.add(nomePredicate);
		}
        if (!ObjectUtils.isEmpty(email)) {
        	predicates.add(emailPredicate);
		}
        
		cq.where(predicates.stream().toArray(Predicate[]::new));
        TypedQuery<Usuario> query = em.createQuery(cq);
        return query.getResultList();
	}

	public Usuario cadastrar(UsuarioRequestDTO form) {
		Optional<Usuario> resultado = repository.findByEmail(form.getEmail());
		if (resultado.isPresent()) {
			throw new AplicacaoException(ExceptionValidacoes.ERRO_EMAIL_JA_CADASTRADO);
		}
		if (!form.getSenha().equals(form.getSenhaConfirmar())) {
			throw new AplicacaoException(ExceptionValidacoes.ERRO_SENHAS_NAO_CORRESPONDEM);
		}
		Plano plano = planoService.buscarPorId(form.getIdPlano());	
		if (plano == null) {
			throw new AplicacaoException(ExceptionValidacoes.ERRO_PLANO_INEXISTENTE);
		}	
		Usuario usuario = form.toUsuario();
		Cartao cartao = cartaoService.cadastrar(form.getNumeroCartao(), form.dataValidade(), form.getCodigoSeguranca(),	form.getNomeTitular(), form.getCpf(), form.getModalidade());
		Favorito f = new Favorito();
		usuario.getPlano().add(plano);
		usuario.setCartao(cartao);
		usuario.setFavorito(f);
		favoritoService.salvar(f);
		repository.save(usuario);

		return usuario;
	}

	public Usuario atualizar(Long id, UsuarioAtualizacaoForm form) {
		Optional<Usuario> resultado1 = repository.findById(id);
		if (!resultado1.isPresent()) {
			throw new AplicacaoException(ExceptionValidacoes.ERRO_USUARIO_NAO_ENCONTRADO);
		}	
		Optional<Usuario> resultado2 = repository.findByEmail(form.getEmail());
		if (resultado2.isPresent()) {
			throw new AplicacaoException(ExceptionValidacoes.ERRO_EMAIL_JA_CADASTRADO);
		}
		if (!form.getSenha().isEmpty() && !form.getSenha().equals(form.getSenhaConfirmar())) {
			throw new AplicacaoException(ExceptionValidacoes.ERRO_SENHAS_NAO_CORRESPONDEM);
		}
		Usuario usuario = resultado1.get();
		
		form.atualizarDados(usuario);
		repository.save(usuario);
		
		return usuario;
	}
	
	public void deletar(Long id) {
		Optional<Usuario> resultado = repository.findById(id);
		if (!resultado.isPresent()) {
			throw new AplicacaoException(ExceptionValidacoes.ERRO_USUARIO_NAO_ENCONTRADO);
		}
		Usuario usuario = resultado.get();
		repository.delete(usuario);
	}

}