package br.com.adamastor.uniespflix.model.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Plano {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private String resolucao;
	private BigDecimal valor;
	@OneToMany(mappedBy = "plano") 
	private List<Usuario> usuario = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getResolucao() {
		return resolucao;
	}
	
	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public List<Usuario> getUsuario() {
		return usuario;
	}
	
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	
	
}
