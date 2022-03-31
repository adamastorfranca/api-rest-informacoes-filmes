package br.com.adamastor.uniespflix.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Filme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private Integer anoLancamento;
	private Integer duracaoMinutos;
	private String sinopse;
	private Integer relevancia;
	private String urlTrailler;	
	@OneToOne
	@JoinColumn(name = "genero_id")
	private Genero genero;
}
