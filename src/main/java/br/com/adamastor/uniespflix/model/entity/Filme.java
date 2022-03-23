package br.com.adamastor.uniespflix.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Filme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private Integer anoLancamento;
	private Integer duracaoMinutos;
	private String sinopse;
	private String urlTrailler;
	private String genero;
	
	public Filme() {
	}
	
	public Filme(String titulo, Integer anoLancamento, Integer duracaoMinutos, String sinopse, String urlTrailler, String genero) {
		this.titulo = titulo;
		this.anoLancamento = anoLancamento;
		this.duracaoMinutos = duracaoMinutos;
		this.sinopse = sinopse;
		this.urlTrailler = urlTrailler;
		this.genero = genero;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(Integer anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	public Integer getDuracaoMinutos() {
		return duracaoMinutos;
	}
	public void setDuracaoMinutos(Integer duracaoMinutos) {
		this.duracaoMinutos = duracaoMinutos;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getUrlTrailler() {
		return urlTrailler;
	}
	public void setUrlTrailler(String urlTrailler) {
		this.urlTrailler = urlTrailler;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Long getId() {
		return id;
	}
}
