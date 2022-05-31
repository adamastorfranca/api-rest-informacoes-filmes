package br.com.adamastor.uniespflix.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.adamastor.uniespflix.model.entity.Filme;
import lombok.Data;

@Data
public class FilmeResponseDTO {
	
	private Long id;
	
	private String titulo;

	private Integer anoLancamento;

	private Integer duracaoMinutos;

	private String sinopse;
	
	private String urlImagem;

	private String urlTrailler;

	private Long idGenero;
	
	private String nomeGenero;
	
	public FilmeResponseDTO(Filme filme) {
		this.id = filme.getId();
		this.titulo = filme.getTitulo();
		this.anoLancamento = filme.getAnoLancamento();
		this.duracaoMinutos = filme.getDuracaoMinutos();
		this.sinopse = filme.getSinopse();
		this.urlImagem = filme.getUrlImagem();
		this.urlTrailler = filme.getUrlTrailler();
		this.idGenero = filme.getGenero().getId();
		this.nomeGenero = filme.getGenero().getNome();
	}

	public static List<FilmeResponseDTO> converter(List<Filme> filmes){
		return filmes.stream().map(FilmeResponseDTO::new).collect(Collectors.toList());
	}
}