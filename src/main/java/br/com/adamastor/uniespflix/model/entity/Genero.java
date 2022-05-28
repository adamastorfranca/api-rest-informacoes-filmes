package br.com.adamastor.uniespflix.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "GENEROS")
@Data
public class Genero implements Serializable {

	private static final long serialVersionUID = -7914375115084101788L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_GENERO")
    private Long id;
    
	@Column(name = "DS_NOME", unique = true, nullable = false)
	private String nome;
    
}
