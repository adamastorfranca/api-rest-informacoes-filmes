package br.com.adamastor.uniespflix.model.form;

import br.com.adamastor.uniespflix.model.entity.Genero;
import lombok.Data;

@Data
public class AtualizacaoGeneroForm {

	private String nomeGenero;
	
	public Genero atualizarDados(Genero genero) {
		if(!nomeGenero.isEmpty()) {
			genero.setNome(nomeGenero);;
		}

		return genero;
	}

}

