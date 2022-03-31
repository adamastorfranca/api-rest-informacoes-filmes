package br.com.adamastor.uniespflix.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Favorito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@OneToMany
	private List<Filme> filmes = new ArrayList<>();
	@OneToMany
	private List<Serie> series = new ArrayList<>();
	
	public void adicionarFilme(Filme filme) {
		filmes.add(filme);
	}
	
	public void removerFilme(Filme filme) {
		filmes.remove(filme);
	}
	
	public void adicionarSerie(Serie serie) {
		series.add(serie);
	}
	
	public void removerSerie(Serie serie) {
		series.remove(serie);
	}
}
