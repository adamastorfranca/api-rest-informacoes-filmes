package br.com.adamastor.uniespflix.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Entity
@Table(name = "CARTOES")
@Data
public class Cartao implements Serializable {
	
	private static final long serialVersionUID = 5731347485453217443L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CARTAO")
	private Long id;
	
	@Column(name = "NU_CARTAO", nullable = false)
	private String numeroCartao;
	
	@Column(name = "DT_VALIDADE", nullable = false)
	private LocalDate validade;
	
	@Column(name = "NU_CODIGO", nullable = false)
	private String codigoSeguranca;
	
	@Column(name = "DS_NOME_TITULAR", nullable = false)
	private String nomeTitular;
	
	@CPF
	@Column(name = "NU_CPF", nullable = false, length = 11)
	private String cpf;

}
