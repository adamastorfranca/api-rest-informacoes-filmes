package br.com.adamastor.uniespflix.model.form;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import br.com.adamastor.uniespflix.model.entity.Usuario;
import lombok.Data;

@Data
public class UsuarioForm {

	@NotEmpty @NotNull
	private String nomeCompleto;
	@NotEmpty @NotNull
	private String dataNascimento;
	@NotEmpty @NotNull @Email
	private String email;
	@NotEmpty @NotNull @Size(min = 8)
	private String senha;
	@NotEmpty @NotNull
	private String senhaConfirmar;
	@NotEmpty @NotNull
	private String nomePlano;
	@NotEmpty @NotNull
	private String numeroCartao;
	@NotEmpty @NotNull
	private String validade;
	@NotEmpty @NotNull
	private String codigoSeguranca;
	@NotEmpty @NotNull
	private String nomeTitular;
	@NotEmpty @NotNull @CPF
	private String cpf;		

	public LocalDate dataValidade() {
		String[] separarData = validade.split("/");
		String mes = separarData[0];
		String ano = separarData[1];
		return LocalDate.of(Integer.parseInt("20" + ano), Integer.parseInt(mes),Month.of(Integer.parseInt(mes)).maxLength());
	}

	public Usuario criarUsuario() {
		Usuario u = new Usuario();
		u.setNomeCompleto(nomeCompleto);
		u.setDataNascimento(LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		u.setEmail(email);
		u.setSenha(senha);		
		return u;
	}

}
