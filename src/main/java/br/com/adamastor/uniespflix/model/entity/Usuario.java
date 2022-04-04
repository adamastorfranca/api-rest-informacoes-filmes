package br.com.adamastor.uniespflix.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeCompleto;
	private LocalDate dataNascimento;
	@Column(unique = true)
	private String email;
	private String senha;
	private String numeroTelefone;
	private Boolean ativo = false;
	@OneToOne
	private Cartao cartao;	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Plano> plano = new ArrayList<>();
	@OneToOne
	private Favorito favorito;
	
	
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

}
