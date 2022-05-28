package br.com.adamastor.uniespflix.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Entity
@Table(name = "USUARIOS")
@Data
public class Usuario implements UserDetails{

	private static final long serialVersionUID = -7838950269775694828L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO", unique = true)
	private Long id;
	
	@Column(name = "DS_NOME", nullable = false)
	private String nomeCompleto;
	
	@Column(name = "DT_NASCIMENTO", nullable = false)
	private LocalDate dataNascimento;
	
	@Column(name = "DS_EMAIL", nullable = false, unique = true)
	private String email;
	
	@Column(name = "SENHA", nullable = false, length = 8)
	private String senha;
	
	@Column(name = "NU_TELEFONE")
	private String numeroTelefone;
	
	@Column(name = "BL_ATIVO")
	private boolean ativo;
	
	@JoinColumn(name = "FK_CARTAO", nullable = false)
	@OneToOne
	private Cartao cartao;	
	
	@JoinColumn(name = "FK_FAVORITO")
	@OneToOne
	private Favorito favorito;

	@Column(name = "FK_PLANO", nullable = false)
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Plano> plano = new ArrayList<>();
	
	
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