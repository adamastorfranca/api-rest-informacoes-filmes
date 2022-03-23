package br.com.adamastor.uniespflix.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Favorito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@OneToOne
	private Usuario usuario;
	@OneToMany
	private List<Filme> filme = new ArrayList<>();
	@OneToMany
	private List<Serie> serie = new ArrayList<>();

}
