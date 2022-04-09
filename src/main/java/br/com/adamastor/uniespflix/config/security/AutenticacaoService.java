package br.com.adamastor.uniespflix.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.adamastor.uniespflix.model.entity.Usuario;
import br.com.adamastor.uniespflix.model.repository.UsuarioRepository;


@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> resultado = usuarioRepository.findByEmail(email);
		if (resultado.isPresent()) {
			return resultado.get();
		}
		
		throw new UsernameNotFoundException("Dados inválidados");
	}
	
	

}
