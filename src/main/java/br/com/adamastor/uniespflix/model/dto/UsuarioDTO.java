package br.com.adamastor.uniespflix.model.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.adamastor.uniespflix.model.entity.Usuario;

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
	}
	
	public Long getId() {
		return id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public String getNomePlano() {
		return nomePlano;
	}

	public static List<UsuarioDTO> converter(List<Usuario> usuarios){
		return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}
}