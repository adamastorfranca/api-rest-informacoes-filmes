package br.com.adamastor.uniespflix.model.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cartao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String numero;
	private String validade;
	private String codigoSeguranca;
	private String nomeTitular;
	private String cpfCnpj;
	@ManyToOne
	private Usuario usuario;
	
	public Cartao() {
	}
	
	public Cartao(String numero, String validade, String codigoSegurancao, String nomeTitular, String cpfCnpj) {
		this.numero = numero;
		this.validade = validade;
		this.codigoSeguranca = codigoSegurancao;
		this.nomeTitular = nomeTitular;
		this.cpfCnpj = cpfCnpj;
	}

	public Long getId() {
		return Id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setCodigoSegurancao(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

}
