package br.com.adamastor.filme.model.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.adamastor.filme.model.entity.Filme;

public class FilmeForm {
	
	@NotNull @NotEmpty
	private String titulo;
	@NotNull @NotEmpty
	private String sinopse;
	@NotNull @NotEmpty
	private String urlTrailler;
	
	public String getTitulo() {
		return titulo;
	}
	public String getSinopse() {
		return sinopse;
	}
	public String getUrlTrailler() {
		return urlTrailler;
	}
	
	public Filme converter() {
		return new Filme(titulo, sinopse, urlTrailler);
	}

}
