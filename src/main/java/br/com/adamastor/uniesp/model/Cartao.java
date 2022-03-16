package br.com.adamastor.uniesp.model;

import java.time.LocalDate;

public class Cartao {
	
	private Long id;
	private Usuario usuario;
	private String numeroDoCartao;
	private LocalDate validade;
	private Integer codigoDeSeguranca;
	private String nomeDoTitular;
	private String cpfCnpj;

}
