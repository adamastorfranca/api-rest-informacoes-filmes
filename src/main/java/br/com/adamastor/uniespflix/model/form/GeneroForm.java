package br.com.adamastor.uniespflix.model.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.adamastor.uniespflix.model.entity.Genero;
import lombok.Data;

@Data
public class GeneroForm {

	@NotEmpty @NotNull
	private String nomeGenero;
	
	public Genero converter() {
		Genero genero = new Genero();
		genero.setNome(nomeGenero);
		return genero;
	}
}
