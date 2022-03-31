package br.com.adamastor.uniespflix.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.adamastor.uniespflix.model.entity.Filme;
import lombok.Data;

@Data
public class FilmeDTO {
	
	private String titulo;
	private Integer anoLancamento;
	private Integer duracaoMinutos;
	private String sinopse;
	private String urlTrailler;
	private String nomeGenero;
	
	public FilmeDTO(Filme filme) {
		this.titulo = filme.getTitulo();
		this.anoLancamento = filme.getAnoLancamento();
		this.duracaoMinutos = filme.getDuracaoMinutos();
		this.sinopse = filme.getSinopse();
		this.urlTrailler = filme.getUrlTrailler();
		this.nomeGenero = filme.getGenero().getNome();
	}

	public static List<FilmeDTO> converter(List<Filme> filmes){
		return filmes.stream().map(FilmeDTO::new).collect(Collectors.toList());
	}
}