package br.com.adamastor.uniesp.model;

import java.util.ArrayList;
import java.util.List;

public class Filme {
	
	private Long id;
	private String titulo;
	private List<Ator> atores;
	
	public Filme(Long id, String titulo) {
		this.id = id;
		this.titulo = titulo;
		this.atores = new ArrayList<>();
	}
	
	public void adicionarAtor(Ator ator) {
		this.atores.add(ator);
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
	public List<Ator> getAtores() {
		return atores;
	}
	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}

	@Override
	public String toString() {
		return "Filme [id = " + id + ", titulo = " + titulo + "]";
	}
	
	

}
