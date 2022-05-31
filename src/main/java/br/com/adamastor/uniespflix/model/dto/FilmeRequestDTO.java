package br.com.adamastor.uniespflix.model.dto;

import br.com.adamastor.uniespflix.model.entity.Filme;
import lombok.Data;

@Data
public class FilmeRequestDTO {
	
	private String titulo;

	private Integer anoLancamento;

	private Integer duracaoMinutos;

	private String sinopse;
	
	private String urlImagem;

	private String urlTrailler;

	private Long idGenero;

	public Filme converter() {
		Filme filme = new Filme();
		filme.setTitulo(titulo);
		filme.setAnoLancamento(anoLancamento);
		filme.setDuracaoMinutos(duracaoMinutos);
		filme.setSinopse(sinopse);
		filme.setUrlImagem(urlImagem);
		filme.setUrlTrailler(urlTrailler);
		
		return filme;
	}
}
