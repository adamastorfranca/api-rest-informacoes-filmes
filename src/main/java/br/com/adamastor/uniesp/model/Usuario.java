package br.com.adamastor.uniesp.model;

import java.time.LocalDate;
import java.util.List;

public class Usuario {
	
	private Long id;
	private String nomeCompleto;
	private LocalDate dataNascimento;
	private String email;
	private String senha;
	private String telefone;
	private Cartao cartao;
	private Plano plano;
	private List<Filme> favoritos;

}
