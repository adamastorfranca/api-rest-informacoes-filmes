package br.com.adamastor.uniesp.model;

import java.time.LocalDate;
import java.util.List;

public class Serie {
	
	private Long id;
	private String titulo;
	private LocalDate anoLancamento;	
	private ClassificaoIndicativa classificacao;
	private Integer relevancia;
	private String sinopse;
	private String urlYoutube;
	private List<Genero> generos;
	private List<Ator> atores;
	private List<Temporada> temporadas;
	private List<Episodio> episodios;


}
