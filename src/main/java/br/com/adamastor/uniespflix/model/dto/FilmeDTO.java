package br.com.adamastor.uniespflix.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.adamastor.uniespflix.model.entity.Filme;

public class FilmeDTO {
	
	private String titulo;
	private Integer anoLancamento;
	private Integer duracaoMinutos;
	private String sinopse;
	private String urlTrailler;
	private String genero;
	
	public FilmeDTO(Filme filme) {
		this.titulo = filme.getTitulo();
		this.anoLancamento = filme.getAnoLancamento();
		this.duracaoMinutos = filme.getDuracaoMinutos();
		this.sinopse = filme.getSinopse();
		this.urlTrailler = filme.getUrlTrailler();
		this.genero = filme.getGenero();
	}

	public String getTitulo() {
		return titulo;
	}

	public Integer getAnoLancamento() {
		return anoLancamento;
	}

	public Integer getDuracaoMinutos() {
		return duracaoMinutos;
	}

	public String getSinopse() {
		return sinopse;
	}

	public String getUrlTrailler() {
		return urlTrailler;
	}

	public String getGenero() {
		return genero;
	}

	public static List<FilmeDTO> converter(List<Filme> filmes){
		return filmes.stream().map(FilmeDTO::new).collect(Collectors.toList());
	}
}