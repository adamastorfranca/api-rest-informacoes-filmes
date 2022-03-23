package br.com.adamastor.uniespflix.model.form;

import br.com.adamastor.uniespflix.model.entity.Filme;

public class FilmeForm {

	private String titulo;
	private Integer anoLancamento;
	private Integer duracaoMinutos;
	private String sinopse;
	private String urlTrailler;
	private String genero;
	
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

	public Filme converter() {;
		return new Filme(titulo, anoLancamento, duracaoMinutos, sinopse, urlTrailler, genero);
	}
}
