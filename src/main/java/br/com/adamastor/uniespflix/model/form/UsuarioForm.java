package br.com.adamastor.uniespflix.model.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.adamastor.uniespflix.model.entity.Usuario;

public class UsuarioForm {

	private String nomeCompleto;
	private String email;
	private String dataNascimento;	
	private String numeroTelefone;
	private String nomePlano;
	private String numeroCartao;
	private String validade;
	private String codigoSeguranca;
	private String nomeTitular;
	private String cpfCnpj;	
	private String senha;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getNomePlano() {
		return nomePlano;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public String getValidade() {
		return validade;
	}

	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public Usuario converter() {
		String senhaHash = new BCryptPasswordEncoder().encode(senha);
		return new Usuario(nomeCompleto, LocalDate.parse(dataNascimento, formatter), email,  senhaHash, numeroTelefone);
	}

}
