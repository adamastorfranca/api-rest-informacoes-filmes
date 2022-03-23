package br.com.adamastor.filme.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.adamastor.filme.model.dto.FilmeDTO;
import br.com.adamastor.filme.model.entity.Filme;

public class FilmeDTO {
	
	private Long id;
	private String titulo;
	
	public FilmeDTO(Filme filme) {
		this.id = filme.getId();
		this.titulo = filme.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public static List<FilmeDTO> converter(List<Filme> filmes){
		return filmes.stream().map(FilmeDTO::new).collect(Collectors.toList());
	}
}