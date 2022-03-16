package br.com.adamastor.uniesp.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Filme {
	
	private Long id;
	private String titulo;
	private LocalTime duracao;
	private LocalDate anoLancamento;	
	private ClassificaoIndicativa classificacao;
	private Integer relevancia;
	private String sinopse;
	private String urlYoutube;
	private List<Genero> generos;
	private List<Ator> atores;

}
