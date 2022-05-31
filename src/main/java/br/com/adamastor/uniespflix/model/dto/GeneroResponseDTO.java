package br.com.adamastor.uniespflix.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.adamastor.uniespflix.model.entity.Genero;
import lombok.Data;

@Data
public class GeneroResponseDTO {

	private Long id;
	
	private String nome;
	
	public GeneroResponseDTO(Genero genero) {
		this.id = genero.getId();
		this.nome = genero.getNome();
	}
	
	public static List<GeneroResponseDTO> converter(List<Genero> generos){
		return generos.stream().map(GeneroResponseDTO::new).collect(Collectors.toList());
	}
}
