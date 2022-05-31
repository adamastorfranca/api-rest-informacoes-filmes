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
@Table(name = "FILMES")
@Data
public class Filme implements Serializable {

	private static final long serialVersionUID = 4466069638950179455L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FILME")
	private Long id;
	
	@Column(name = "DS_TITULO", nullable = false)
	private String titulo;
	
	@Column(name = "NU_ANO_LANCAMENTO", nullable = false)
	private Integer anoLancamento;
	
	@Column(name = "NU_DURACAO", nullable = false)
	private Integer duracaoMinutos;
	
	@Column(name = "DS_SINOPSE", nullable = false, length = 2000)
	private String sinopse;
	
	@Column(name = "DS_URL_IMAGEM", nullable = false)
	private String urlImagem;	

	@Column(name = "DS_URL_TRAILLER", nullable = false)
	private String urlTrailler;	
	
	@JoinColumn(name = "FK_GENERO", nullable = false)
	@OneToOne	
	private Genero genero;

}
