package br.com.adamastor.uniespflix.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Filme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	@OneToMany
	private Genero genero;
	private Integer anoLancamento;
	private Integer duracaoMinutos;
	private String sinopse;
	private Integer relevancia;
	private String urlTrailler;	

}
