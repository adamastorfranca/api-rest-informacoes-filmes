package br.com.adamastor.uniespflix.model.form;

import br.com.adamastor.uniespflix.model.entity.Filme;
import lombok.Data;

@Data
public class FilmeAtualizacaoForm {

	private String titulo;
	private String nomeGenero;
	private Integer anoLancamento;
	private Integer duracaoMinutos;
	private String sinopse;
	private Integer relevancia;
	private String urlTrailler;	
	
	public Filme atualizarDados(Filme filme) {
		if(!titulo.isEmpty()) {
			filme.setTitulo(titulo);
		}
		if(anoLancamento != null || (anoLancamento >= 1900 && anoLancamento <= 2022)) {
			filme.setAnoLancamento(anoLancamento);
		}
		if(duracaoMinutos != null || (duracaoMinutos >= 30 && duracaoMinutos <= 180)) {
			filme.setDuracaoMinutos(duracaoMinutos);
		}
		if(sinopse.isEmpty()) {
			filme.setSinopse(sinopse);
		}
		if(relevancia != null || (relevancia >= 0 && relevancia <= 100)) {
			filme.setRelevancia(relevancia);
		}
		if(!urlTrailler.isEmpty()) {
			filme.setUrlTrailler(urlTrailler);
		}
		return filme;
	}

}

