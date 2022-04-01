package br.com.adamastor.uniespflix.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.adamastor.uniespflix.model.entity.Genero;
import lombok.Data;

@Data
public class GeneroDTO {

	private String nome;
	
	public GeneroDTO(Genero genero) {
		this.nome = genero.getNome();
	}
	
	public static List<GeneroDTO> converter(List<Genero> generos){
		return generos.stream().map(GeneroDTO::new).collect(Collectors.toList());
	}
}
