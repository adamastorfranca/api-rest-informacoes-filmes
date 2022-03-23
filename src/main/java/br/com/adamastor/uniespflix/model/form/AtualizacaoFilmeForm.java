package br.com.adamastor.uniespflix.model.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.adamastor.uniespflix.model.entity.Filme;

public class AtualizacaoFilmeForm {


	@NotNull @NotEmpty
	private String sinopse;
	@NotNull @NotEmpty
	private String urlTrailler;
	
	public String getSinopse() {
		return sinopse;
	}
	public String getUrlTrailler() {
		return urlTrailler;
	}
	
	public Filme converter() {
		Filme filme = new Filme();
		filme.setSinopse(sinopse);
		filme.setUrlTrailler(urlTrailler);
		return filme;
	}

}

