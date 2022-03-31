package br.com.adamastor.uniespflix.model.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.adamastor.uniespflix.model.entity.Serie;
import lombok.Data;

@Data
public class SerieForm {
	
	@NotEmpty @NotNull
	private String titulo;
	@NotEmpty @NotNull
	private Integer anoLancamento;
	@NotEmpty @NotNull
	private Integer temporadas;
	@NotEmpty @NotNull
	private String sinopse;
	@NotEmpty @NotNull
	private String urlTrailler;
	@NotEmpty @NotNull
	private String nomeGenero;

	public Serie converter() {
		Serie serie = new Serie();
		serie.setTitulo(titulo);
		serie.setAnoLancamento(anoLancamento);
		serie.setDuracaoMinutos(duracaoMinutos);
		serie.setSinopse(sinopse);
		serie.setUrlTrailler(urlTrailler);
		return serie;
	}
}
