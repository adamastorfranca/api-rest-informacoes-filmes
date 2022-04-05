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
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "usuarios")
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
	
	private Boolean ativo = false;
	
	@OneToOne
	private Cartao cartao;	
	
	@OneToOne
	private Favorito favorito = new Favorito();
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Plano> plano = new ArrayList<>();
	
}
