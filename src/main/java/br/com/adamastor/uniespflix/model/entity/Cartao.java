package br.com.adamastor.uniespflix.model.entity;

import java.time.LocalDate;

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
	private LocalDate validade;
	private String codigoSeguranca;
	private String nomeTitular;
	private String cpf;
	
	public Cartao() {}
	
	public Cartao(String numeroCartao, LocalDate validade, String codigoSegurancao, String nomeTitular, String cpf) {
		this.numeroCartao = numeroCartao;
		this.validade = validade;
		this.codigoSeguranca = codigoSegurancao;
		this.nomeTitular = nomeTitular;
		this.cpf = cpf;
	}
}
