package br.com.adamastor.uniespflix.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "SERIES")
@Data
public class Serie implements Serializable {

	private static final long serialVersionUID = 3628210753235853003L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SERIE")
	private Long id;
	
	@Column(name = "DS_TITULO", nullable = false)
	private String titulo;
	
	@Column(name = "NU_ANO_LANCAMENT0", nullable = false)
	private Integer anoLancamento;
	
	@Column(name = "NU_TEMPORADAS", nullable = false)
	private Integer temporadas;
	
	@Column(name = "DS_SINOPSE", nullable = false)
	private String sinopse;

	@Column(name = "DS_URL_TRAILLER", nullable = false)
	private String urlTrailler;
	
	@JoinColumn(name = "FK_GENERO", nullable = false)
	@OneToOne	
	private Genero genero;

}
