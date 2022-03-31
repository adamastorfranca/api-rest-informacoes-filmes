package br.com.adamastor.uniespflix.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.adamastor.uniespflix.model.entity.Serie;
import lombok.Data;

@Data
public class SerieDTO {
	
	private String titulo;
	private Integer anoLancamento;
	private Integer temporadas;
	private String sinopse;
	private String urlTrailler;
	private String nomeGenero;
	
	public SerieDTO(Serie serie) {
		this.titulo = serie.getTitulo();
		this.anoLancamento = serie.getAnoLancamento();
		this.temporadas = serie.getTemporadas();
		this.sinopse = serie.getSinopse();
		this.urlTrailler = serie.getUrlTrailler();
		this.nomeGenero = serie.getGenero().getNome();
	}

	public static List<SerieDTO> converter(List<Serie> series){
		return series.stream().map(SerieDTO::new).collect(Collectors.toList());
	}
}