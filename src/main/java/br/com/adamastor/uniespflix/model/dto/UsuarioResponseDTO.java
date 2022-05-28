package br.com.adamastor.uniespflix.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.adamastor.uniespflix.model.entity.Usuario;
import lombok.Data;

@Data
public class UsuarioResponseDTO implements Serializable {

	private static final long serialVersionUID = 8349326733250298963L;

	private Long id;
	
	private String nomeCompleto;
	
	private LocalDate dataNascimento;
	
	private String email;
	
	private String numeroTelefone;
	
	private String nomePlano;
	
	private boolean ativo;

	
	public UsuarioResponseDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nomeCompleto = usuario.getNomeCompleto();
		this.dataNascimento = usuario.getDataNascimento();
		this.email = usuario.getEmail();
		this.numeroTelefone = usuario.getNumeroTelefone();
		this.nomePlano = usuario.getPlano().get(0).getNome();
		this.ativo = usuario.isAtivo();
	}
	
	public static List<UsuarioResponseDTO> converter(List<Usuario> usuarios){
		return usuarios.stream().map(UsuarioResponseDTO::new).collect(Collectors.toList());
	}
}