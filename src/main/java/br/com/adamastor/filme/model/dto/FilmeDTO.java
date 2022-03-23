package br.com.adamastor.filme.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.adamastor.filme.model.dto.FilmeDTO;
import br.com.adamastor.filme.model.entity.Filme;

public class FilmeDTO {
	
	private Long id;
	private String titulo;
	private String sinopse;
	private String urlTrailler;
	
	public FilmeDTO(Filme filme) {
		this.id = filme.getId();
		this.titulo = filme.getTitulo();
		this.sinopse = filme.getSinopse();
		this.urlTrailler = filme.getUrlTrailler();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public String getUrlTrailler() {
		return urlTrailler;
	}

	public static List<FilmeDTO> converter(List<Filme> filmes){
		return filmes.stream().map(FilmeDTO::new).collect(Collectors.toList());
	}
}