package br.com.adamastor.uniespflix.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.adamastor.uniespflix.model.entity.Usuario;
import lombok.Data;

@Data
public class UsuarioRequestDTO implements Serializable {

	private static final long serialVersionUID = -7860495095887497668L;

	private String nomeCompleto;
	
	private LocalDate dataNascimento;
	
	private String email;
	
	private String senha;
	
	private String senhaConfirmar;

	private Long idPlano;
	
	private String numeroCartao;
	
	private String validade;
	
	private String codigoSeguranca;
	
	private String nomeTitular;
	
	private String cpf;
	
	private String modalidade;


	public Usuario toUsuario() {
		Usuario u = new Usuario();
		u.setNomeCompleto(nomeCompleto.toUpperCase());
		u.setDataNascimento(dataNascimento);
		u.setEmail(email);
		String senhaHash = new BCryptPasswordEncoder().encode(senha);
		u.setSenha(senhaHash);
		u.setAtivo(true);

		return u;
	}
	
	public LocalDate dataValidade() {
		String[] separarData = validade.split("/");
		String mes = separarData[0];
		String ano = separarData[1];
		
		return LocalDate.of(Integer.parseInt("20" + ano), Integer.parseInt(mes),Month.of(Integer.parseInt(mes)).maxLength());
	}

}
