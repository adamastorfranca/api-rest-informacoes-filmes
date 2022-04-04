package br.com.adamastor.uniespflix.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.adamastor.uniespflix.exception.AplicacaoException;
import br.com.adamastor.uniespflix.exception.ExceptionValidacoes;
import br.com.adamastor.uniespflix.model.dto.UsuarioDTO;
import br.com.adamastor.uniespflix.model.entity.Cartao;
import br.com.adamastor.uniespflix.model.entity.Favorito;
import br.com.adamastor.uniespflix.model.entity.Plano;
import br.com.adamastor.uniespflix.model.entity.Usuario;
import br.com.adamastor.uniespflix.model.form.UsuarioForm;
import br.com.adamastor.uniespflix.model.repository.CartaoRepository;
import br.com.adamastor.uniespflix.model.repository.FavoritoRepository;
import br.com.adamastor.uniespflix.model.repository.PlanoRepository;
import br.com.adamastor.uniespflix.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PlanoRepository planoRepository;
	@Autowired
	private CartaoRepository cartaoRepository;
	@Autowired
	private FavoritoRepository favoritoRepository;

	public List<UsuarioDTO> buscarTodosUsuarios(){	
		return UsuarioDTO.converter(usuarioRepository.findAll());
	}
	
	@Transactional(rollbackFor = Exception.class)
	public UsuarioDTO cadastrar(UsuarioForm form) {
		Optional<Usuario> resultado = usuarioRepository.findByEmail(form.getEmail());
		if(resultado.isPresent()){
			throw new AplicacaoException(ExceptionValidacoes.ERRO_EMAIL_JA_CADASTRADO);
		}
		if(!form.getSenha().equals(form.getSenhaConfirmar())) {
			throw new AplicacaoException(ExceptionValidacoes.ERRO_SENHAS_NAO_CORRESPONDEM);
		}
		
		Cartao cartao = new Cartao(form.getNumeroCartao(), form.dataValidade(), form.getCodigoSeguranca(), form.getNomeTitular(), form.getCpf());
		cartaoRepository.save(cartao);
		
		Plano plano = planoRepository.findByNome(form.getNomePlano());
		
		Favorito favorito = new Favorito();
		favoritoRepository.save(favorito);
		
		Usuario usuario = form.converter();	
		usuario.adicionarPlano(plano);		
		usuario.setFavorito(favorito);		
		usuario.setCartao(cartao);
		usuarioRepository.save(usuario);
		
		return new UsuarioDTO(usuario);	
	}
}