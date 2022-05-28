package br.com.adamastor.uniespflix.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "FAVORITOS")
@Data
public class Favorito implements Serializable {

	private static final long serialVersionUID = 9085702376436627027L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FAVORITO")
	Long id;
	
	@Column(name = "FK_FILME")
	@OneToMany
	private List<Filme> filmes = new ArrayList<>();
	
	@Column(name = "FK_SERIE")
	@OneToMany
	private List<Serie> series = new ArrayList<>();

}
