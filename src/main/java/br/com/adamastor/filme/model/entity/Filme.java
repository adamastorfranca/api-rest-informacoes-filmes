package br.com.adamastor.filme.model.entity;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Filme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;	
	private String sinopse;
	private String urlTrailler;
	
	public Filme() {
	}
	
	public Filme(String titulo, String sinopse, String urlTrailler) {
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.urlTrailler = urlTrailler;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
}
