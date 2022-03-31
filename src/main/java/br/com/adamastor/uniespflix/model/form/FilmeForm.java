package br.com.adamastor.uniespflix.model.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.adamastor.uniespflix.model.entity.Filme;
import lombok.Data;

@Data
public class FilmeForm {
	
	@NotEmpty @NotNull
	private String titulo;
	@NotEmpty @NotNull
	private Integer anoLancamento;
	@NotEmpty @NotNull
	private Integer duracaoMinutos;
	@NotEmpty @NotNull
	private String sinopse;
	@NotEmpty @NotNull
	private String urlTrailler;
	@NotEmpty @NotNull
	private String nomeGenero;

	public Filme converter() {
		Filme filme = new Filme();
		filme.setTitulo(titulo);
		filme.setAnoLancamento(anoLancamento);
		filme.setDuracaoMinutos(duracaoMinutos);
		filme.setSinopse(sinopse);
		filme.setUrlTrailler(urlTrailler);
		return filme;
	}
}
