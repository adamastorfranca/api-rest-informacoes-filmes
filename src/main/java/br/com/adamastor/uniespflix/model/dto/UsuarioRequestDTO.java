package br.com.adamastor.uniespflix.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.adamastor.uniespflix.exception.AplicacaoException;
import br.com.adamastor.uniespflix.exception.ExceptionValidacoes;
import br.com.adamastor.uniespflix.model.entity.Cartao;
import br.com.adamastor.uniespflix.model.entity.Usuario;
import lombok.Data;

@Data
public class UsuarioRequestDTO implements Serializable {

	private static final long serialVersionUID = -7860495095887497668L;

	private String nomeCompleto;
	
	private String dataNascimento;
	
	private String email;
	
	private String senha;
	
	private String senhaConfirmar;
	
	private String numeroTelefone;
	
	private String nomePlano; // FALTA
	
	private String numeroCartao;
	
	private String validade;
	
	private String codigoSeguranca;
	
	private String nomeTitular;
	
	private String cpf;		


	public Usuario toUsuario() {
		Usuario u = new Usuario();
		u.setNomeCompleto(nomeCompleto);
		u.setDataNascimento(LocalDate.parse(dataNascimento));
		u.setEmail(email);
		if(senha.equals(senhaConfirmar)) {
			throw new AplicacaoException(ExceptionValidacoes.ERRO_SENHAS_NAO_CORRESPONDEM);
		}
		String senhaHash = new BCryptPasswordEncoder().encode(senha);
		u.setSenha(senhaHash);
		u.setNumeroTelefone(numeroCartao);
		u.setAtivo(true);

		return u;
	}
	
	public Cartao toCartao() {
		Cartao c = new Cartao();
		c.setNumeroCartao(numeroCartao);
		c.setValidade(dataValidade());
		c.setCodigoSeguranca(codigoSeguranca);
		c.setNomeTitular(nomeTitular);
		c.setCpf(cpf);
		
		return c;
	}
	
	public LocalDate dataValidade() {
		String[] separarData = validade.split("/");
		String mes = separarData[0];
		String ano = separarData[1];
		
		return LocalDate.of(Integer.parseInt("20" + ano), Integer.parseInt(mes),Month.of(Integer.parseInt(mes)).maxLength());
	}

}
