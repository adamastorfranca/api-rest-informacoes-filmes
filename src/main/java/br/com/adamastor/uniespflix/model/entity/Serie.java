package br.com.adamastor.uniespflix.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Serie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private Integer anoLancamento;
	private Integer temporadas;
	private String sinopse;
	private String urlTrailler;
	private String genero;

}
