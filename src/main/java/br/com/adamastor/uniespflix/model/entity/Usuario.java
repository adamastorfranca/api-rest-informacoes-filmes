package br.com.adamastor.uniespflix.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Entity
@Data
public class Usuario implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeCompleto;
	private LocalDate dataNascimento;
	private String email;
	private String senha;
	private String numeroTelefone;
	@OneToOne
	private Cartao cartao;	
	@OneToOne
	private Favorito favorito;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Plano> plano = new ArrayList<>();
	
	public Usuario() {}
	
	public Usuario(String nomeCompleto, LocalDate dataNascimento, String email, String senha,
			String numeroTelefone) {
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
		this.numeroTelefone = numeroTelefone;
	}
	
	public void adicionarPlano(Plano plano) {
		this.plano.add(plano);		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.plano;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
