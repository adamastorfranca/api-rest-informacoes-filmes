package br.com.adamastor.uniespflix.model.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.adamastor.uniespflix.model.entity.Usuario;
import lombok.Data;

@Data
public class UsuarioDTO {
	
	private Long id;
	private String nomeCompleto;
	private String email;
	private String nomePlano;
	private String numeroTelefone;
	private LocalDate dataNascimento;

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nomeCompleto = usuario.getNomeCompleto();
		this.dataNascimento =usuario.getDataNascimento();
		this.email = usuario.getEmail();
		this.numeroTelefone = usuario.getNumeroTelefone();
		this.nomePlano = usuario.getPlano().get(0).getNome();
	}
	
	public static List<UsuarioDTO> converter(List<Usuario> usuarios){
		return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}
}