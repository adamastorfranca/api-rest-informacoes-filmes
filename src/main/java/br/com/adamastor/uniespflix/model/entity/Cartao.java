package br.com.adamastor.uniespflix.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Cartao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numeroCartao;
	private String validade;
	private String codigoSeguranca;
	private String nomeTitular;
	private String cpfCnpj;
	
	public Cartao() {}
	
	public Cartao(String numeroCartao, String validade, String codigoSegurancao, String nomeTitular, String cpfCnpj) {
		this.numeroCartao = numeroCartao;
		this.validade = validade;
		this.codigoSeguranca = codigoSegurancao;
		this.nomeTitular = nomeTitular;
		this.cpfCnpj = cpfCnpj;
	}
}
