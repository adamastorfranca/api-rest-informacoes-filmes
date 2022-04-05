package br.com.adamastor.uniespflix.model.form;

import javax.validation.constraints.Size;

import br.com.adamastor.uniespflix.model.entity.Usuario;
import lombok.Data;

@Data
public class UsuarioAtualizacaoForm {

	private Long id;
	private String nomeCompleto;
	private String email;
	@Size(min = 8)
	private String senha;
	private String senhaConfirmar;
	
	public Usuario atualizarDados(Usuario usuario) {
		if(!nomeCompleto.isEmpty()) {
			usuario.setNomeCompleto(nomeCompleto);
		}
		if(!email.isEmpty()) {
			usuario.setEmail(email);
		}
		if(!senha.isEmpty()) {
			usuario.setSenha(senha);
		}

		return usuario;
	}

}

