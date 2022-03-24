package br.com.adamastor.uniespflix.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adamastor.uniespflix.model.dto.UsuarioDTO;
import br.com.adamastor.uniespflix.model.entity.Cartao;
import br.com.adamastor.uniespflix.model.entity.Plano;
import br.com.adamastor.uniespflix.model.entity.Usuario;
import br.com.adamastor.uniespflix.model.form.UsuarioForm;
import br.com.adamastor.uniespflix.model.repository.CartaoRepository;
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

	public List<UsuarioDTO> buscarTodosUsuarios(){	
		return UsuarioDTO.converter(usuarioRepository.findAll());
	}
	
	public UsuarioDTO cadastrar(UsuarioForm form) {
		Usuario usuario = form.converter();
		Plano plano = planoRepository.findByNome(form.getNomePlano());
		Cartao cartao = new Cartao(form.getNumeroCartao(), form.getValidade(), form.getCodigoSeguranca(), form.getNomeTitular(), form.getCpfCnpj());
		usuario.setPlano(plano);
		usuario.setCartao(cartao);
		cartao.setUsuario(usuario);
		cartaoRepository.save(cartao);
		usuarioRepository.save(usuario);
		return new UsuarioDTO(usuario);
	}
}