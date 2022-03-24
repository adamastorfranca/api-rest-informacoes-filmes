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

@Entity
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
	
	public Usuario() {
	}
	
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

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNumeroTelefone() {
		return numeroTelefone;
	}
	
	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
	
	public Cartao getCartao() {
		return cartao;
	}
	
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public Favorito getFavorito() {
		return favorito;
	}
	
	public void setFavorito(Favorito favorito) {
		this.favorito = favorito;
	}

	public List<Plano> getPlano() {
		return plano;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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
