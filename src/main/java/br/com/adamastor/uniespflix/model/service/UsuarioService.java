package br.com.adamastor.uniespflix.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public UsuarioDTO cadastrar(UsuarioForm form) {
		Optional<Usuario> resultado = usuarioRepository.findByEmail(form.getEmail());
		if(resultado.isPresent()){
			return null;
		}
		Favorito favorito = new Favorito();
		favoritoRepository.save(favorito);
		Cartao cartao = new Cartao(form.getNumeroCartao(), form.getValidade(), form.getCodigoSeguranca(), form.getNomeTitular(), form.getCpfCnpj());
		cartaoRepository.save(cartao);
		Plano plano = planoRepository.findByNome(form.getNomePlano());
		Usuario usuario = form.converter();	
		usuario.adicionarPlano(plano);		
		usuario.setFavorito(favorito);		
		usuario.setCartao(cartao);
		usuarioRepository.save(usuario);
		return new UsuarioDTO(usuario);	
	}
}