package br.com.adamastor.uniespflix.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Serie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private Integer anoLancamento;
	private Integer temporadas;
	private String sinopse;
	private Integer relevancia;
	private String urlTrailler;
	@OneToMany
	private Genero genero;

}
