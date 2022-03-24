package br.com.adamastor.uniespflix.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cartao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String numeroCartao;
	private String validade;
	private String codigoSeguranca;
	private String nomeTitular;
	private String cpfCnpj;
	
	public Cartao() {
	}
	
	public Cartao(String numeroCartao, String validade, String codigoSegurancao, String nomeTitular, String cpfCnpj) {
		this.numeroCartao = numeroCartao;
		this.validade = validade;
		this.codigoSeguranca = codigoSegurancao;
		this.nomeTitular = nomeTitular;
		this.cpfCnpj = cpfCnpj;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
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

	public void setCodigoSeguranca(String codigoSeguranca) {
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

	public Long getId() {
		return Id;
	}
}
